package com.example.SeProject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class AgreementService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer agreementServiceId;
    private String customerDetails;
    private String location;
    private String item;
    private String agreementType;
    private String periodOfTheAgreement;
}
