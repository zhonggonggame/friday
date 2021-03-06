package com.sxbang.friday.service;

import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.model.Shopcontext;

import java.util.Map;

public interface ShopcontextService {

   Results getByPage(Map<String, Object> params, Integer offset, Integer limit);

   Results  save(Shopcontext shopcontext);

   Results  getById(Integer id);

   Results update(Shopcontext shopcontext);

   Results  delete(Shopcontext shopcontext);

   Results  search(Map<String, Object> params, Integer offset, Integer limit);

}

