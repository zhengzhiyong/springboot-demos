package com.sby.controller;

import com.sby.po.BootySchool;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping
public class IndexController {

    /**
     *
     * @return
     */
    @RequestMapping(value = "/getMyPdf")
    public ModelAndView getMyPdf(){
        return new ModelAndView("pdf");
    }
}
