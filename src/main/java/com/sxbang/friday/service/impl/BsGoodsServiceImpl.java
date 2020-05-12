package com.sxbang.friday.service.impl;

import com.sxbang.friday.base.result.ResponseCode;
import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.dao.BsGoodsDao;
import com.sxbang.friday.model.BsGoods;
import com.sxbang.friday.service.BsGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Service
public class  BsGoodsServiceImpl implements BsGoodsService {

    @Autowired
    private BsGoodsDao bsGoodsDao;

    @Override
    public Results<BsGoods> getByPage(Map<String, Object> params,Integer offset, Integer limit) {
        return new Results(0,"",null,bsGoodsDao.count(params), bsGoodsDao.list(params,offset, limit));

    }

    @Override
    public Results save(BsGoods bsGoods) {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.format(date);
        bsGoods.setPublishDate(sdf.format(date));
        int res =  bsGoodsDao.save(bsGoods);
        Results results = new Results();
        results.setCode(ResponseCode.SUCCESS.getCode());
        results.setMsg(ResponseCode.SUCCESS.getMessage());
        return results;
    }

    @Override
    public Results getById(Integer id) {
        BsGoods res =  bsGoodsDao.getById(id);
        Results results = new Results();
        results.setCode(ResponseCode.SUCCESS.getCode());
        results.setMsg(ResponseCode.SUCCESS.getMessage());
        if (res==null){
            results.setCode(ResponseCode.FAIL.getCode());
        }
        return results;
    }

    @Override
    public BsGoods getBsGoodsById(Integer id) {
        return bsGoodsDao.getById(id);
    }


    @Override
    @Transactional
    public Results update(BsGoods bsGoods) {
        int res =  bsGoodsDao.update(bsGoods);
        Results results = new Results();
        results.setCode(ResponseCode.SUCCESS.getCode());
        results.setMsg(ResponseCode.SUCCESS.getMessage());
        return results;
    }

    @Override
    @Transactional
    public Results delete(BsGoods bsGoods) {
        int res =  bsGoodsDao.delete(bsGoods);
        Results results = new Results();
        results.setCode(ResponseCode.SUCCESS.getCode());
        results.setMsg(ResponseCode.SUCCESS.getMessage());
        return results;
    }





}
