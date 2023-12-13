package com.socft.drugproject.main;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface MainDao {

    List<MenuVo> getMenuList(String userType); // 메뉴 목록 리스트 조회

    List<DrugVo> getDrugInfo(); //약물 정보 조회

    SideEffectVo getDrugDetail(int drugId); //약물 상세조회

    InteractionVo getInteraction(int drug1, int drug2); //약물 상호작용 조회

    void updateUserType(Long id); //사용자 권한: 일반사용자 -> 전문직 변경

    void insertDrug(String drugName, String manufacturer, String description); //약물 추가

    void insertSideEffect(String description); //약물 부작용 추가

    void deleteDrug(Long drugId); //약물 삭제

    void updateDrug(Long drugId, String drugName, String manufacturer, String description); //약물 수정

    void updateSideEffect(Long drugId, String description); //약물 부작용 수정

    void insertFeedback(Long userId, String feedback); //사용자 -> 피드백 추가
}
