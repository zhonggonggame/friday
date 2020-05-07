package com.sxbang.friday.service.impl;

import com.sxbang.friday.base.result.ResponseCode;
import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.dao.OrderformDao;
import com.sxbang.friday.dto.OrderFormVO;
import com.sxbang.friday.service.OrderformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class  OrderformServiceImpl implements OrderformService {

    @Autowired
    private OrderformDao orderformDao;

    @Override
    public Results<OrderFormVO> getByPage(Map<String, Object> params,Integer offset, Integer limit) {
        List<OrderFormVO> list= orderformDao.list(params,offset,limit);
        list.forEach(l->l.setDetailAddress(l.getProvince()+l.getCity()+l.getArea()+l.getDetailAddress()));
        return new Results(0,"",null,orderformDao.count(params),list);

    }

    @Override
    public OrderFormVO getOrderformById(String id) {
       OrderFormVO orderFormVO= orderformDao.getById(id);
       orderFormVO.setDetailAddress(orderFormVO.getProvince()+orderFormVO.getCity()+orderFormVO.getArea()+orderFormVO.getDetailAddress());
       return orderFormVO;
    }

    @Override
    public Results update(OrderFormVO orderFormVO) {
        int i=orderformDao.update(orderFormVO);
        Results results = new Results();
        results.setCode(ResponseCode.SUCCESS.getCode());
        results.setMsg(ResponseCode.SUCCESS.getMessage());
        return results;
    }

    @Override
    public Results delete(OrderFormVO orderFormVO) {
        int i=orderformDao.delete(orderFormVO);
        Results results = new Results();
        results.setCode(ResponseCode.SUCCESS.getCode());
        results.setMsg(ResponseCode.SUCCESS.getMessage());
        return results;
    }


}
