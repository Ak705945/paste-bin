package com.armaan.pastebin.services;

import com.armaan.pastebin.entities.PasteBinDataEntity;
import com.armaan.pastebin.repositories.PasteBinDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PasteBinService {
    @Autowired
    PasteBinDataRepository pasteBinDataRepository;
    public boolean pushPasteBinData(String data,String id){
        try {
            pasteBinDataRepository.save(PasteBinDataEntity.builder()
                    .data(data)
                    .id(id)
                    .build());
            return true;
        }catch (Exception e) {
            return false;
        }
    }
    public Optional<PasteBinDataEntity> fetchPasteBinDataById(String id){
        return pasteBinDataRepository.findById(id);
    }
}
