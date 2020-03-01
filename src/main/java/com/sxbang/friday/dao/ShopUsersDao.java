package com.sxbang.friday.dao;


import java.util.List;
import java.util.Map;

import com.sxbang.friday.model.ShopUsers;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;



@Mapper
public interface ShopUsersDao {

    @Select("select * from shop_users t where t.id = #{id}")
    ShopUsers getById(Integer id);

    @Delete("delete from shop_users where id = #{id}")
    int delete(ShopUsers shopUsers);

    int update(ShopUsers shopUsers);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into shop_users(user_id, user_name, portrait, phone, user_password, shcool) values(#{userId}, #{userName}, #{portrait}, #{phone}, #{userPassword}, #{shcool})")
    int save(ShopUsers shopUsers);
    
    int count(@Param("params") Map<String, Object> params);

    List<ShopUsers> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);

}
