package com.socft.drugproject.main;

import lombok.Data;

@Data
public class SideEffectVo {
    Long sideEffectId;
    String drugId;
    String description;
}
