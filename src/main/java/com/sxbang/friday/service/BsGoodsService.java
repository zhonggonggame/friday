package com.sxbang.friday.service;

import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.model.BsGoods;

import java.util.Map;

public interface BsGoodsService {

   Results<BsGoods>  getByPage(Map<String, Object> params, Integer offset, Integer limit);

   Results  save(BsGoods bsGoods);

   Results  getById(Integer id);

   Results update(BsGoods bsGoods);

   Results  delete(BsGoods bsGoods);

   BsGoods getBsGoodsById(Integer id);




}

