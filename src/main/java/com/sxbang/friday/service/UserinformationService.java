package com.sxbang.friday.service;

import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.model.Userinformation;

public interface UserinformationService {

   Results<Userinformation>  getByPage(Integer offset, Integer limit);

   Results  save(Userinformation userinformation);

   Results  getById(Integer id);

   Results update(Userinformation userinformation);

   Results  delete(Userinformation userinformation);

   Userinformation getUserinformationById(Integer id);

   Results search(Userinformation userinformation);
}

