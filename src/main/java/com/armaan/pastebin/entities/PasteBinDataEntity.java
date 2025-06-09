package com.armaan.pastebin.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PASTEBIN_DATA")
@Data
@Builder
@NoArgsConstructor      // 👈 Required by JPA
@AllArgsConstructor
public class PasteBinDataEntity {
    @Id
    private String id;
    @Lob
    private String data;
}
