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

}
