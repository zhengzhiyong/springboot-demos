package com.sby.service;

import com.sby.po.BootySchool;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zheng on 2018/6/15.
 */
@Service
public interface SchoolService {
    List<BootySchool> getAllSchoolList();

    BootySchool getBootySchoolById(Long id);

    int insertBootySchool(Long id,String name,int star,String address,int teacherNumber,int studentNumber,String introduction);

    int deleteBootySchoolById(@Param("id") Long id);
}
