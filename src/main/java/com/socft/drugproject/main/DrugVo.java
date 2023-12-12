package com.socft.drugproject.main;

import lombok.Data;

@Data
public class DrugVo {
    private Long drugId;
    private String drugName;
    private String manufacturer;
    private String registrationDate;
    private String modificationDate;

}
