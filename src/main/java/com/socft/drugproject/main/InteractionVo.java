package com.socft.drugproject.main;

import lombok.Data;

@Data
public class InteractionVo {
    private Long interactionId;
    private String drug1Id;
    private String drug2Id;
    private String interactionContent;
    private String registrationDate;
    private String modificationDate;
}
