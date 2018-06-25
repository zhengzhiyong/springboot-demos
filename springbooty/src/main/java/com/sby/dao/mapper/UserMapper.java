package com.sby.dao.mapper;

import com.github.pagehelper.Page;
import com.sby.po.BootySchool;
import com.sby.po.User;
import org.apache.ibatis.annotations.*;

/**
 * Created by zheng on 2018/6/20.
 */
@Mapper
public interface UserMapper {

    /**
     *
     * @param account
     * @param password
     * @return
     */
    @Select("SELECT ID,ACCOUNT,PASSWORD,NAME,NICK_NAME FROM PERM_ACCOUNT WHERE ACCOUNT = #{account} AND PASSWORD =#{password}")
    @Results({
            @Result(id =true,column = "ID",property = "id"),
            @Result(column = "ACCOUNT",property = "account"),
            @Result(column = "PASSWORD",property = "password"),
            @Result(column = "NAME",property = "name"),
            @Result(column = "NICK_NAME",property = "nickName")
    })
    @ResultType(BootySchool.class)
    User getUserInfo(@Param("account") String account,@Param("password") String password);


    /**
     *
     * @return
     */
    @Select("SELECT ID,ACCOUNT,PASSWORD,NAME,NICK_NAME FROM PERM_ACCOUNT")
    @Results({
            @Result(id =true,column = "ID",property = "id"),
            @Result(column = "ACCOUNT",property = "account"),
            @Result(column = "PASSWORD",property = "password"),
            @Result(column = "NAME",property = "name"),
            @Result(column = "NICK_NAME",property = "nickName")
    })
    @ResultType(BootySchool.class)
    Page<User> getUserList();


    /**
     *
     * @param user
     */
    @Update("UPDATE PERM_ACCOUNT SET ACCOUNT = #{user.account},NAME = #{user.name},NICK_NAME = #{user.nickName} WHERE ID = #{user.id} ")
    void updateUser(@Param("user") User user);


    /**
     *
     * @param id
     */
    @Delete("DELETE FROM PERM_ACCOUNT WHERE ID = #{id}")
    void deleteUserById(@Param("id") Long id);

    /**
     *
     * @param id
     * @return
     */
    @Select("SELECT ID,ACCOUNT,PASSWORD,NAME,NICK_NAME FROM PERM_ACCOUNT WHERE ID =#{id}")
    @Results({
            @Result(id =true,column = "ID",property = "id"),
            @Result(column = "ACCOUNT",property = "account"),
            @Result(column = "PASSWORD",property = "password"),
            @Result(column = "NAME",property = "name"),
            @Result(column = "NICK_NAME",property = "nickName")
    })
    @ResultType(BootySchool.class)
    User getUser(@Param("id") Long id);


//    @Insert("insert into PERM_ACCOUNT(id,name,nick_name,password,account) values(#{id},#{name},#{nickName},#{password},#{account})")
//    int save(@Param("id") Long id,@Param("name") String name,@Param("nickName") String nickName,@Param("password") String password,@Param("account") String account);
    @Insert("insert into PERM_ACCOUNT(id,name,nick_name,password,account) values(#{user.id},#{user.name},#{user.nickName},#{user.password},#{user.account})")
    int save(@Param("user") User user);

    @Select("select (max(id)+1) as id from perm_account")
    Long getMaxId();
}
