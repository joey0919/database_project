package com.socft.drugproject.main;

import lombok.Data;

@Data
public class SideEffectVo { //약물 부작용 데이터
    Long sideEffectId; //약물부작용 id
    String drugId; //약물 id
    String description; //약물 부작용 내용
}
