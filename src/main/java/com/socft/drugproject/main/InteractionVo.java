package com.socft.drugproject.main;

import lombok.Data;

@Data
public class InteractionVo { //약물 상호작용 데이터
    private Long interactionId; //상호작용 id
    private String drug1Id; //약물1 id
    private String drug2Id; //약물2 id
    private String interactionContent; //상호작용 내용
    private String registrationDate; //등록일
    private String modificationDate; //수정일
}
