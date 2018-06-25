package com.sby.controller;

import com.sby.bean.BookBean;
import com.sby.po.BootySchool;
import com.sby.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zheng on 2018/6/14.
 */
@RestController
@RequestMapping
public class HelloController {

    @Autowired
    private BookBean bookBean;

    @Autowired
    private SchoolService schoolService;

    /**
     *
     * @return
     */
    @RequestMapping("/helloWorld")
    public String helloWorld(){
        return "hello World";
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/getBookList",method = RequestMethod.GET)
    @ResponseBody
    public List<BookBean> getBookList(){
        List<BookBean> books = new ArrayList();
        for (int i = 0;i< 10 ;i++){
            books.add(bookBean);
        }
        return books;
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/getBookBean",method = RequestMethod.GET)
    @ResponseBody
    public BookBean getBookBean(){
        return bookBean;
    }


    /**
     *
     * @return
     */
    @RequestMapping(value = "/getBootySchoolList",method = RequestMethod.GET)
    @ResponseBody
    public List<BootySchool> getBootySchoolList(){
        return schoolService.getAllSchoolList();
    }



    /**
     * 根据ID删除学校
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteBootySchool/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String deleteBootySchool(@PathVariable("id") Long id){
        schoolService.deleteBootySchoolById(id);
        return "删除成功";
    }

    /**
     * 新增学校
     * @return
     */
    @RequestMapping(value = "/insertBootySchool",method = RequestMethod.GET)
    @ResponseBody
    public String insertBootySchool(){
        schoolService.insertBootySchool(2L,"xuexiao mingcheng ",2,"address",1111,22222,"introduction");
        return "新增成功";
    }
}
