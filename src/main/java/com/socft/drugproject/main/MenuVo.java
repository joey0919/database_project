package com.socft.drugproject.main;

import lombok.Data;

@Data
public class MenuVo {
    private Long id;
    private String menuNm;
    private String expertAccess;
    private String userAccess;
    private String url;

}
