package com.sxbang.friday.service.impl;

import com.sxbang.friday.base.result.ResponseCode;
import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.dao.ShopcontextDao;
import com.sxbang.friday.model.Shopcontext;
import com.sxbang.friday.service.ShopcontextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class  ShopcontextServiceImpl implements ShopcontextService {

    @Autowired
    private ShopcontextDao shopcontextDao;

    @Override
    public Results<Shopcontext> getByPage(Map<String, Object> params,Integer offset, Integer limit) {
        return new Results(0,"",null,shopcontextDao.count(params), shopcontextDao.list(params,offset, limit));

    }

    @Override
    public Results save(Shopcontext shopcontext) {
        /*int res = 0;
        if(StringUtils.isEmpty(sysLogs.getId())){
            res =  shopcontextDao.save(shopcontext);
        }else{
            res =  shopcontextDao.update(shopcontext);
        }*/
        Results results = new Results();
        results.setCode(ResponseCode.SUCCESS.getCode());
        results.setMsg(ResponseCode.SUCCESS.getMessage());
        return results;
    }

    @Override
    public Results getById(Integer id) {
        Shopcontext res =  shopcontextDao.getById(id);
        Results results = new Results();
        results.setCode(ResponseCode.SUCCESS.getCode());
        results.setMsg(ResponseCode.SUCCESS.getMessage());
        return results;
    }

    @Override
    public Shopcontext getShopcontextById(Integer id) {
        return shopcontextDao.getById(id);
    }

    @Override
    @Transactional
    public Results update(Shopcontext shopcontext) {
        int res =  shopcontextDao.update(shopcontext);
        Results results = new Results();
        results.setCode(ResponseCode.SUCCESS.getCode());
        results.setMsg(ResponseCode.SUCCESS.getMessage());
        return results;
    }

    @Override
    @Transactional
    public Results delete(Shopcontext shopcontext) {
        int res =  shopcontextDao.delete(shopcontext);
        Results results = new Results();
        results.setCode(ResponseCode.SUCCESS.getCode());
        results.setMsg(ResponseCode.SUCCESS.getMessage());
        return results;
    }

}
