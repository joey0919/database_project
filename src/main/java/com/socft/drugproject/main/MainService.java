package com.socft.drugproject.main;

import java.util.List;
import java.util.Map;

public interface MainService {

    List<MenuVo> getMenuList(String userType) throws Exception; // 메뉴 목록 리스트 조회

    List<DrugVo> getDrugInfo() throws Exception; //약물 정보 조회

    SideEffectVo getDrugDetail(int drugId) throws Exception; //약물 상세조회

    InteractionVo getInteraction(int drug1, int drug2) throws Exception; //약물 상호작용 조회

    void updateUserType(Long id) throws Exception; //사용자 권한: 일반사용자 -> 전문직 변경

    void insertDrug(String drugName, String manufacturer, String description); //약물 추가

    void updateDrug(Long drugId, String drugName, String manufacturer, String description); //약물 수정
    void deleteDrug(Long drugId) throws Exception; //약물 삭제

    void insertFeedback(Long userId, String feedback) throws Exception; //사용자 -> 피드백 추가

}
