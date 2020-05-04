package com.sxbang.friday.dao;

import com.sxbang.friday.model.Allkinds;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface AllkindsDao {

    @Select("select * from allkinds t where t.id = #{id}")
    Allkinds getById(Integer id);

    @Delete("delete from allkinds where id = #{id}")
    int delete(Allkinds allkinds);

    int update(Allkinds allkinds);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into allkinds(name, modified) values(#{name}, #{modified})")
    int save(Allkinds allkinds);
    
    int count(@Param("params") Map<String, Object> params);

    List<Allkinds> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);

}
