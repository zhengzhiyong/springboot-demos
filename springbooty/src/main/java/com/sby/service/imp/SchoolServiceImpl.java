package com.sby.service.imp;

import com.sby.dao.mapper.SchoolMapper;
import com.sby.po.BootySchool;
import com.sby.service.SchoolService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolMapper schoolMapper;

    @Override
    public List<BootySchool> getAllSchoolList() {
        return schoolMapper.getAllSchoolList();
    }

    @Override
    public BootySchool getBootySchoolById(Long id) {
        return schoolMapper.getBootySchoolById(id);
    }

    @Override
    public int insertBootySchool(Long id, String name, int star, String address, int teacherNumber, int studentNumber, String introduction) {
        return schoolMapper.insertBootySchool(id,name,star,address,teacherNumber,studentNumber,introduction);
    }

    @Override
    public int deleteBootySchoolById(@Param("id") Long id) {
        return schoolMapper.deleteBootySchoolById(id);
    }
}
