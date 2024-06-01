package com.example.SeProject.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AgreementServiceDto {
    private Integer agreementServiceId;
    private String customerDetails;
    private String location;
    private String item;
    private String agreementType;
    private String periodOfTheAgreement;

}
