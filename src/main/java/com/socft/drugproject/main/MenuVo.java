package com.socft.drugproject.main;

import lombok.Data;

@Data
public class MenuVo { //메뉴 데이터
    private Long id; //메뉴 id
    private String menuNm; //메뉴 이름
    private String expertAccess; //전문직 접근 가능 여부
    private String userAccess; //일반사용자 접근 가능 여부
    private String url; //메뉴 url

}
