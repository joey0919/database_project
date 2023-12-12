package com.socft.drugproject.main;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface MainDao {

    List<Map> getTest();

    List<MenuVo> getMenuList(String userType);

    List<DrugVo> getDrugInfo();

    SideEffectVo getDrugDetail(int drugId);

    InteractionVo getInteraction(int drug1, int drug2);

    void updateUserType(Long id);

    void insertDrug(String drugName, String manufacturer, String description);

    void insertSideEffect(String description);

    void deleteDrug(Long drugId);

    void updateDrug(Long drugId, String drugName, String manufacturer, String description);

    void updateSideEffect(Long drugId, String description);
}
