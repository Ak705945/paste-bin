    package com.armaan.pastebin.controllers;

    import com.armaan.pastebin.entities.PasteBinDataEntity;
    import com.armaan.pastebin.services.PasteBinService;
    import com.armaan.pastebin.utils.RandomGenerator;
    import jakarta.websocket.server.PathParam;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.servlet.view.RedirectView;

    import java.util.Optional;

    @Controller
    //@RequestMapping("/bin")
    public class PasteBinController {

        @Autowired
        PasteBinService pasteBinService;


        @GetMapping("/home")
        public String index() {
            return "inputBin";
        }

        @PostMapping("/save")
        public RedirectView saveBin(@RequestParam("message") String message) {

            String id=RandomGenerator.generateId();
            if(pasteBinService.pushPasteBinData(message,id)){
                String redirectUrl="/view/"+id;
                return new RedirectView(redirectUrl);
            }
            else{
                String redirectUrl="/error";
                return new RedirectView(redirectUrl);
            }
        }

        @GetMapping("/view/{binId}")
        public String viewBin(@PathVariable("binId") String binId, Model model) {
            Optional<PasteBinDataEntity> pasteBinDataEntity=pasteBinService.fetchPasteBinDataById(binId);
            pasteBinDataEntity.ifPresent(binDataEntity -> model.addAttribute("message", binDataEntity.getData()));
            //Fetch code from DB

            return "viewBin";

        }

    }