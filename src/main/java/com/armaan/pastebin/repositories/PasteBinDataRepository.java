package com.armaan.pastebin.repositories;


import com.armaan.pastebin.entities.PasteBinDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasteBinDataRepository extends JpaRepository<PasteBinDataEntity,String> {

}
