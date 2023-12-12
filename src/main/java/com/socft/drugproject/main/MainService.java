package com.socft.drugproject.main;

import java.util.List;
import java.util.Map;

public interface MainService {

    List<Map> getTest() throws Exception;

    List<MenuVo> getMenuList(String userType) throws Exception;

    List<DrugVo> getDrugInfo() throws Exception;

    //약물 부작용 조회
    SideEffectVo getDrugDetail(int drugId) throws Exception;

    InteractionVo getInteraction(int drug1, int drug2) throws Exception;

    void updateUserType(Long id) throws Exception;

    void insertDrug(String drugName, String manufacturer, String description);

    void updateDrug(Long drugId, String drugName, String manufacturer, String description);
    void deleteDrug(Long drugId) throws Exception;

}
