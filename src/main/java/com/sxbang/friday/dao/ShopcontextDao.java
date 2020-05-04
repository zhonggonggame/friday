package com.sxbang.friday.dao;

import com.sxbang.friday.model.Shopcontext;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ShopcontextDao {

    @Select("select * from shopcontext t where t.id = #{id}")
    Shopcontext getById(Integer id);

    @Delete("delete from shopcontext where id = #{id}")
    int delete(Shopcontext shopcontext);

    int update(Shopcontext shopcontext);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into shopcontext(modified, sid, context, display, uid) values(#{modified}, #{sid}, #{context}, #{display}, #{uid})")
    int save(Shopcontext shopcontext);
    
    int count(@Param("params") Map<String, Object> params);

    List<Shopcontext> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);

}
