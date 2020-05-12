package com.sxbang.friday.service;

import java.util.List;
import java.util.Map;

/**
 * @author lhx
 * @date 2020/5/7 21:08
 * @description
 */
public interface DataAnalysisService {

    void insertUserAddCount();

    List<Map<String,String>> selectAddUserCount();

    void insertPayAmount();

    List<Map<String,String>> selectPayAmount();


}
