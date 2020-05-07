package com.sxbang.friday.service;

import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.dto.OrderFormVO;

import java.util.Map;

public interface OrderformService {

   Results<OrderFormVO>  getByPage(Map<String, Object> params, Integer offset, Integer limit);

   OrderFormVO getOrderformById(String id);

   Results update(OrderFormVO orderFormVO);

   Results  delete(OrderFormVO orderFormVO);


}

