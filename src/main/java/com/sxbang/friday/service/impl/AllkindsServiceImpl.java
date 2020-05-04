package com.sxbang.friday.service.impl;

import com.sxbang.friday.base.result.ResponseCode;
import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.dao.AllkindsDao;
import com.sxbang.friday.model.Allkinds;
import com.sxbang.friday.service.AllkindsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class  AllkindsServiceImpl implements AllkindsService {

    @Autowired
    private AllkindsDao allkindsDao;

    @Override
    public Results<Allkinds> getByPage(Map<String, Object> params,Integer offset, Integer limit) {
        return new Results(0,"",null,allkindsDao.count(params), allkindsDao.list(params,offset, limit));

    }

    @Override
    public Results save(Allkinds allkinds) {
        int res = 0;
            res =  allkindsDao.save(allkinds);
        Results results = new Results();
        results.setCode(ResponseCode.SUCCESS.getCode());
        results.setMsg(ResponseCode.SUCCESS.getMessage());
        return results;
    }

    @Override
    public Results getById(Integer id) {
        Allkinds res =  allkindsDao.getById(id);
        Results results = new Results();
        results.setCode(ResponseCode.SUCCESS.getCode());
        results.setMsg(ResponseCode.SUCCESS.getMessage());
        return results;
    }

    @Override
    public Allkinds getAllkindsById(Integer id) {
        return allkindsDao.getById(id);
    }

    @Override
    public Results update(Allkinds allkinds) {
        int res =  allkindsDao.update(allkinds);
        Results results = new Results();
        results.setCode(ResponseCode.SUCCESS.getCode());
        results.setMsg(ResponseCode.SUCCESS.getMessage());
        return results;
    }

    @Override
    @Transactional
    public Results delete(Allkinds allkinds) {
        int res =  allkindsDao.delete(allkinds);
        Results results = new Results();
        results.setCode(ResponseCode.SUCCESS.getCode());
        results.setMsg(ResponseCode.SUCCESS.getMessage());
        return results;
    }

}
