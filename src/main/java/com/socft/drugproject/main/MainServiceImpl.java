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
}
