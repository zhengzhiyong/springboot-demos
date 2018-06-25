package com.sby.controller;

import com.github.pagehelper.PageInfo;
import com.sby.model.PageRespModel;
import com.sby.model.RespModel;
import com.sby.po.User;
import com.sby.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by zheng on 2018/6/21.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     *
     * @param startRow
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/getUserList")
    @ResponseBody
    public PageRespModel getUserList(int startRow, int pageSize){
        PageInfo<User> users = userService.getUserList(startRow,pageSize);
        PageRespModel model = new PageRespModel();
        model.setRows(users.getList());
        model.setTotal((int)users.getTotal());
        return model;
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/get")
    @ResponseBody
    public RespModel get(Long id){
        RespModel respModel = new RespModel();
        User user = userService.getUser(id);
        respModel.setRows(user);
        return respModel;
    }

    /**
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public RespModel update(User user){
        RespModel respModel = new RespModel();
        userService.updateUser(user);
        return respModel;
    }

    @RequestMapping(value = "/viewUser")
    public ModelAndView viewUser(Long id){
        User user = userService.getUser(id);
        ModelAndView modelAndView = new ModelAndView("viewUser");
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping(value = "/editUser")
    public ModelAndView editUser(Long id){
        User user = userService.getUser(id);
        ModelAndView modelAndView = new ModelAndView("editUser");
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping(value = "/addUser")
    public ModelAndView addUser(){
        return new ModelAndView("addUser");
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public RespModel add(User user){
        RespModel respModel = new RespModel();
        userService.save(user);
        return respModel;
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public RespModel delete(Long id){
        RespModel respModel = new RespModel();
        userService.deleteUserById(id);
        return respModel;
    }
}
