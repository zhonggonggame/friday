package com.sxbang.friday.dao;

import com.sxbang.friday.model.Userinformation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserinformationDao {

    /**
     * 查看用户信息。
     * @param id
     * @return
     */
    @Select("select * from bs_user t where t.id = #{id}")
    Userinformation getById(Integer id);

    /**
     * 删除用户
     * @param userinformation
     * @return
     */
    @Delete("delete from bs_user where id = #{id}")
    int delete(Userinformation userinformation);

    /**
     * 修改
     * @param userinformation
     * @return
     */
    int update(Userinformation userinformation);

    /**
     * 新增用户
     * @param userinformation
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into userinformation(modified, username, phone, realname, clazz, sno, dormitory, gender, createtime, avatar) values(#{modified}, #{username}, #{phone}, #{realname}, #{clazz}, #{sno}, #{dormitory}, #{gender}, #{createtime}, #{avatar})")
    int save(Userinformation userinformation);

    /**
     * 总数
     * @return
     */
    int count();

    /**
     * 用户列表
     * @param offset
     * @param limit
     * @return
     */
    List<Userinformation> list(@Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 查找
     * @param userinformation
     * @return
     */
    @Select("select * from  userinformation where username=#{username}")
    Userinformation search(Userinformation userinformation);

}
