package com.socft.drugproject.main;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class MainServiceImpl implements MainService{

    private final MainDao mainDao;


    @Override
    public List<Map> getTest() throws Exception {
        return this.mainDao.getTest();
    }

    @Override
    public List<MenuVo> getMenuList(String userType) throws Exception {
        return this.mainDao.getMenuList(userType);
    }

    @Override
    public List<DrugVo> getDrugInfo() throws Exception {
        return this.mainDao.getDrugInfo();
    }

    @Override
    public SideEffectVo getDrugDetail(int drugId) throws Exception {
        return this.mainDao.getDrugDetail(drugId);
    }

    @Override
    public InteractionVo getInteraction(int drug1, int drug2) throws Exception {
        return this.mainDao.getInteraction(drug1, drug2);
    }

    @Override
    public void updateUserType(Long id) throws Exception {
        this.mainDao.updateUserType(id);
    }

    @Override
    public void insertDrug(String drugName, String manufacturer, String description) {
        this.mainDao.insertDrug(drugName, manufacturer, description);
        this.mainDao.insertSideEffect(description);
    }

    @Override
    public void updateDrug(Long drugId, String drugName, String manufacturer, String description) {
        this.mainDao.updateDrug(drugId, drugName, manufacturer, description);
        this.mainDao.updateSideEffect(drugId, description);
    }

    @Override
    public void deleteDrug(Long drugId) throws Exception {
        this.mainDao.deleteDrug(drugId);
    }
}
