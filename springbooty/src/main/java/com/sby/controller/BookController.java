package com.sby.controller;

import com.sby.po.BootySchool;
import com.sby.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * Created by zheng on 2018/6/19.
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private SchoolService schoolService;

    /**
     *
     * @return
     */
    @RequestMapping(value = "/getBooks")
    public ModelAndView getBookList(){
        ModelAndView modelAndView = new ModelAndView("book/books");
        List<BootySchool> list = schoolService.getAllSchoolList();
        modelAndView.addObject("type","type的类型是123");
        modelAndView.addObject("list",list);
        return modelAndView;
    }

    /**
     * spring mvc restful 风格
     * @param id
     * @return
     */
    @RequestMapping(value = "/getBootySchool/{id}",method = RequestMethod.GET)
    @ResponseBody
    public BootySchool getBootySchoolById(@PathVariable("id") Long id){
        return schoolService.getBootySchoolById(id);
    }
}
