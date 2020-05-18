package com.sxbang.friday.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author lhx
 * @date 2020/5/7 21:07
 * @description
 */
@Mapper
@Repository
public interface DataAnalysisDao {

    @Insert("insert into addUserCount select SUBSTRING(u.createtime,1,10),count(*) from bs_user u where u.createtime like #{date}'%' \n")
    int  insertAddUserCount(String date);

    @Select("select count(*) from bs_user u where u.createtime like #{date}'%'")
    int  select(String date);


    List<Map<String,String>> selectAddUserCount(List<String> list);

    @Select("select count(*) from bs_order bo,bs_order_item boi,bs_goods bb where bo.id = boi.order_id AND boi.goods_id = bb.id and bo.order_status=1  and bo.create_date like #{date}'%'")
    int  select2(String date);


    @Insert("insert into payamount SELECT SUBSTRING(bo.create_date,1,10),sum(bb.new_price) as money FROM bs_order bo,bs_order_item boi,bs_goods bb where bo.id = boi.order_id AND boi.goods_id = bb.id and bo.order_status=1  and bo.create_date like #{date}'%'")
    int insertPayAmount(String date);


    List<Map<String,String>> selectPayAmount(List<String> list);
}
