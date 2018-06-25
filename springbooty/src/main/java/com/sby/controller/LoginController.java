package com.sby.controller;

import com.sby.model.RespModel;
import com.sby.po.User;
import com.sby.shiro.SessionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zheng on 2018/6/20.
 */
@Controller
@RequestMapping
public class LoginController {

    /**
     * 登陆后跳转的首页
     * @return
     */
    @RequestMapping(value = {"/index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        Long userId = SessionUtils.getSessionUserId();
        //mv.addObject("menus", menuService.listTreeMenus(userId));
        return mv;
    }

    /**
     * 登陆页
     *
     * @return
     * @history
     */
    @RequestMapping(value = "/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }


    /**
     * 主页面
     *
     * @return
     * @history
     */
    @RequestMapping(value = "/main")
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView("main");
        User user = SessionUtils.getSessionUser();
        modelAndView.addObject("user",user);
        return modelAndView;
    }
    /**
     * 登陆
     *
     * @param username
     * @param password
     * @throws Exception
     * @history
     */
    @RequestMapping(value = "/doLogin")
    @ResponseBody
    public RespModel doLogin(String username, String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            SecurityUtils.getSubject().login(token);
            return RespModel.success("登录成功!");
        } catch (Exception ex) {
            return RespModel.failure("登录失败!");
        }
    }

    /**
     * 登出
     *
     * @return
     * @throws Exception
     * @history
     */
    @RequestMapping(value = "/doLogout")
    public String doLogout() {
        SecurityUtils.getSubject().logout();
        SecurityUtils.getSubject().getSession().removeAttribute(SessionUtils.SESSION_USER_KEY);
        return "redirect:/login";
    }
}
