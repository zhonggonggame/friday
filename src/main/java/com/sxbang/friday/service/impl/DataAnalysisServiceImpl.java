package com.sxbang.friday.service.impl;

import com.sxbang.friday.dao.DataAnalysisDao;
import com.sxbang.friday.service.DataAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author lhx
 * @date 2020/5/7 21:08
 * @description
 */
@Service
public class DataAnalysisServiceImpl implements DataAnalysisService {

    @Autowired
    DataAnalysisDao dataAnalysisDao;

    @Scheduled(cron = "0 0 0 */1 * ?")
    @Override
    public void insertUserAddCount() {
        SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
        String date =sdf.format(new Date());
        int i=dataAnalysisDao.select(date);
        if (i!=0){
            dataAnalysisDao.insertAddUserCount(date);
        }
    }

    @Override
    public List<Map<String, String>> selectAddUserCount() {
        List<String> ids=new ArrayList<>();
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
        for (int i=0;i<=6;i++){
            calendar.add(Calendar.DAY_OF_MONTH,-1);
            ids.add(sdf.format(calendar.getTime()));
        }
        return dataAnalysisDao.selectAddUserCount(ids);
    }

    @Override
    public void insertPayAmount() {
        SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
        String date =sdf.format(new Date());
        int i=dataAnalysisDao.select2(date);
        if (i!=0){
            dataAnalysisDao.insertPayAmount(date);
        }
    }

    @Override
    public List<Map<String, String>> selectPayAmount() {
        List<String> ids=new ArrayList<>();
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
        for (int i=0;i<=6;i++){
            calendar.add(Calendar.DAY_OF_MONTH,-1);
            ids.add(sdf.format(calendar.getTime()));
        }
        return dataAnalysisDao.selectPayAmount(ids);
    }


}
