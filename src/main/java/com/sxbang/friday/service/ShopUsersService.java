package com.sxbang.friday.service;

import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.model.ShopUsers;

import java.util.Map;

public interface ShopUsersService {

   Results<ShopUsers> getByPage(Map<String, Object> params, Integer offset, Integer limit);

   Results  save(ShopUsers shopUsers);

   Results  getById(Integer id);

   Results update(ShopUsers shopUsers);

   Results  delete(ShopUsers shopUsers);

   ShopUsers getShopUsersById(Integer id);

}

