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
    public List<MenuVo> getMenuList(String userType) throws Exception { // 메뉴 목록 리스트 조회
        return this.mainDao.getMenuList(userType);
    }

    @Override
    public List<DrugVo> getDrugInfo() throws Exception { //약물 정보 조회
        return this.mainDao.getDrugInfo();
    }

    @Override
    public SideEffectVo getDrugDetail(int drugId) throws Exception { //약물 상세조회
        return this.mainDao.getDrugDetail(drugId);
    }

    @Override
    public InteractionVo getInteraction(int drug1, int drug2) throws Exception { //약물 상호작용 조회
        return this.mainDao.getInteraction(drug1, drug2);
    }

    @Override
    public void updateUserType(Long id) throws Exception { //사용자 권한: 일반사용자 -> 전문직 변경
        this.mainDao.updateUserType(id);
    }

    @Override
    public void insertDrug(String drugName, String manufacturer, String description) { //약물 추가
        this.mainDao.insertDrug(drugName, manufacturer, description);
        this.mainDao.insertSideEffect(description);
    }

    @Override
    public void updateDrug(Long drugId, String drugName, String manufacturer, String description) { //약물 수정
        this.mainDao.updateDrug(drugId, drugName, manufacturer, description);
        this.mainDao.updateSideEffect(drugId, description);
    }

    @Override
    public void deleteDrug(Long drugId) throws Exception { //약물 삭제
        this.mainDao.deleteDrug(drugId);
    }

    @Override
    public void insertFeedback(Long userId, String feedback) throws Exception { //사용자 -> 피드백 추가
        this.mainDao.insertFeedback(userId, feedback);
    }
}
