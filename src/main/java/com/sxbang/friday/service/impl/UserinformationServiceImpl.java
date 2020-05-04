package com.sxbang.friday.service.impl;

import com.sxbang.friday.base.result.ResponseCode;
import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.dao.UserinformationDao;
import com.sxbang.friday.model.Userinformation;
import com.sxbang.friday.service.UserinformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class  UserinformationServiceImpl implements UserinformationService {

    @Autowired
    private UserinformationDao userinformationDao;

    @Override
    public Results<Userinformation> getByPage(Integer offset, Integer limit) {
        return new Results(0,"",null,userinformationDao.count(), userinformationDao.list(offset, limit));

    }

    @Override
    public Results save(Userinformation userinformation) {
        int res = 0;
       /* if(StringUtils.isEmpty(sysLogs.getId())){
            res =  userinformationDao.save(userinformation);
        }else{
            res =  userinformationDao.update(userinformation);
        }*/
        Results results = new Results();
        results.setCode(ResponseCode.SUCCESS.getCode());
        results.setMsg(ResponseCode.SUCCESS.getMessage());
        return results;
    }

    @Override
    public Results getById(Integer id) {
        Userinformation res =  userinformationDao.getById(id);
        Results results = new Results();
        results.setCode(ResponseCode.SUCCESS.getCode());
        results.setMsg(ResponseCode.SUCCESS.getMessage());
        return results;
    }

    @Override
    public Userinformation getUserinformationById(Integer id) {
        return userinformationDao.getById(id);
    }

    @Override
    public Results search(Userinformation userinformation) {
        List<Userinformation> list=new ArrayList();
        list.add(userinformationDao.search(userinformation));
        return new Results(0,"",null,1,list);
    }

    @Override
    @Transactional
    public Results update(Userinformation userinformation) {
        int res =  userinformationDao.update(userinformation);
        Results results = new Results();
        results.setCode(ResponseCode.SUCCESS.getCode());
        results.setMsg(ResponseCode.SUCCESS.getMessage());
        return results;
    }

    @Override
    @Transactional
    public Results delete(Userinformation userinformation) {
        int res =  userinformationDao.delete(userinformation);
        Results results = new Results();
        results.setCode(ResponseCode.SUCCESS.getCode());
        results.setMsg(ResponseCode.SUCCESS.getMessage());
        return results;
    }

}
