package com.sxbang.friday.dao;

import com.sxbang.friday.dto.OrderFormVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface OrderformDao {


    @Select("SELECT\n" +
            "\t\tbo.order_num,\n" +
            "\t\tbo.order_status,\n" +
            "\t\tbo.create_date,\n" +
            "\t\tbo.status,\n" +
            "\t\tbu.username,\n" +
            "\t\tbu.phone,\n" +
            "\t\tba.receiver,\n" +
            "\t\tba.province,\n" +
            "\t\tba.city,\n" +
            "\t\tba.area,\n" +
            "\t\tba.detail_address,\n" +
            "\t\tsum(bb.new_price) as money\n" +
            "\t\tFROM\n" +
            "\t\tbs_order bo,\n" +
            "\t\tbs_user bu,\n" +
            "\t\tbs_address ba,\n" +
            "\t\tbs_order_item boi,\n" +
            "\t\tbs_goods bb\n" +
            "where bo.user_id = bu.id\n" +
            "        AND bo.address_id = ba.id\n" +
            "        AND bo.id = boi.order_id\n" +
            "        AND boi.goods_id = bb.id\n" +
            "and bo.order_num=#{id} ")
    OrderFormVO getById(String id);


    int count(@Param("params") Map<String, Object> params);

    List<OrderFormVO>  list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);


    int update(OrderFormVO orderFormVO);


    @Delete("delete from bs_order where order_num = #{orderNum}")
    int delete(OrderFormVO orderFormVO);
}
