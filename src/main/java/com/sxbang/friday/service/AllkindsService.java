package com.sxbang.friday.service;

import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.model.Allkinds;

import java.util.Map;

public interface AllkindsService {

   Results<Allkinds>  getByPage(Map<String, Object> params, Integer offset, Integer limit);

   Results  save(Allkinds allkinds);

   Results  getById(Integer id);

   Results update(Allkinds allkinds);

   Results  delete(Allkinds allkinds);

   Allkinds getAllkindsById(Integer id);

}

