package com.sby.dao.mapper;

import com.sby.po.BootySchool;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *
 * https://blog.csdn.net/kingice1014/article/details/70263148
 * Mybatis mapper 注解详细使用方式
 *
 *
 * Created by zheng on 2018/6/15.
 * 基于注释的写法，另外还有一种基于xml配置的方式
 */
@Mapper
public interface SchoolMapper{
    /**
     * 没有使用@Results和@Result前，teacherNumber和studentNumber获取的值均为0
     *
     * 查询学校集合
     * @return
     */
    @Select("SELECT ID,NAME,STAR,ADDRESS,TEACHER_NUMBER,STUDENT_NUMBER,INTRODUCTION FROM BOOTY_SCHOOL")
    @Results({
            @Result(id =true,column = "ID",property = "id"),
            @Result(column = "NAME",property = "name"),
            @Result(column = "STAR",property = "star"),
            @Result(column = "ADDRESS",property = "address"),
            @Result(column = "TEACHER_NUMBER",property = "teacherNumber"),
            @Result(column = "STUDENT_NUMBER",property = "studentNumber"),
            @Result(column = "INTRODUCTION",property = "introduction")
    })
    List<BootySchool> getAllSchoolList();

    /**
     * 根据ID查询学校
     * @param id
     * @return
     */
    @Select("SELECT ID,NAME,STAR,ADDRESS,TEACHER_NUMBER,STUDENT_NUMBER,INTRODUCTION FROM BOOTY_SCHOOL WHERE ID=#{id}")
    @ResultType(BootySchool.class)
    BootySchool getBootySchoolById(@Param("id") Long id);

    /**
     * 新增学校
     * @param id
     * @param name
     * @param star
     * @param address
     * @param teacherNumber
     * @param studentNumber
     * @param introduction
     * @return
     */
    @Insert("insert into booty_school values(#{id},#{name},#{star},#{address},#{teacher_number},#{student_number},#{introduction})")
    int insertBootySchool(@Param("id") Long id,@Param("name") String name,@Param("star") int star,@Param("address") String address,@Param("teacher_number") int teacherNumber,@Param("student_number") int studentNumber,@Param("introduction") String introduction);


    @Delete("delete from booty_school where id = #{id} ")
    int deleteBootySchoolById(@Param("id") Long id);

}
