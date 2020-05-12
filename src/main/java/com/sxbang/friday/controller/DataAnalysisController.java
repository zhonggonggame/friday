package com.sxbang.friday.controller;

import com.sxbang.friday.service.impl.DataAnalysisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lhx
 * @date 2020/5/7 21:04
 * @description
 */
@Controller
@RequestMapping("/dataAnalysis")
public class DataAnalysisController {
    @Autowired
    DataAnalysisServiceImpl dataAnalysisService;

    /**
     * 用户新增统计
     * @return
     */
    @RequestMapping("/listPage")
    @ResponseBody
    public Map selectAddUserCount(){
        List<Map<String,String>> list=dataAnalysisService.selectAddUserCount();
        List<String>  x=new ArrayList<>();
        List<String>  y=new ArrayList<>();
        list.forEach(map->{
            x.add(map.get("id"));
            y.add(map.get("count"));
        });
        Map map=new HashMap();
        map.put("x",x);
        map.put("y",y);
        return map;
    }
    /**
     * 交易量统计
     *
     */
    @RequestMapping("/amount")
    @ResponseBody
    public Map selectAmount(){
        List<Map<String,String>> list=dataAnalysisService.selectPayAmount();
        List<String>  x=new ArrayList<>();
        List<String>  y=new ArrayList<>();
        list.forEach(map->{
            x.add(map.get("id"));
            y.add(map.get("amount"));
        });
        Map map=new HashMap();
        map.put("x",x);
        map.put("y",y);
        return map;
    }




}
