package com.sby.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
@RequestMapping(value = "/test")
public class SEEController {
    //设置响应格式
    @RequestMapping(value = "/push", produces = "text/event-stream;charset=UTF-8")
    public @ResponseBody String push() {
        Random r = new Random();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //SSE返回数据格式是固定的以data:开头，以\n\n结束
        return "data:{Testing：[ 1,2,3" + r.nextInt() + "]}\n\n";
    }
}
