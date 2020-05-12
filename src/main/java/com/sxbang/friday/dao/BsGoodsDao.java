package com.sxbang.friday.dao;

import com.sxbang.friday.model.BsGoods;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface BsGoodsDao {

    @Select("select * from bs_goods t where t.id = #{id}")
    BsGoods getById(Integer id);

    @Delete("delete from bs_goods where id = #{id}")
    int delete(BsGoods bsGoods);

    int update(BsGoods bsGoods);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into bs_goods(name, publish_date, publisher, old_price, new_price, suit, style, category, info, img_url) values(#{name}, #{publishDate}, #{publisher}, #{oldPrice}, #{newPrice}, #{suit}, #{style}, #{category}, #{info}, #{imgUrl})")
    int save(BsGoods bsGoods);
    
    int count(@Param("params") Map<String, Object> params);

    List<BsGoods> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);


}
