package com.socft.drugproject.main;

import lombok.Data;

@Data
public class DrugVo { // 약물 데이터
    private Long drugId; //약물 id
    private String drugName; //약물 이름
    private String manufacturer; //제조사
    private String registrationDate; //등록일
    private String modificationDate; //수정일

}
