package com.sby.controller;


import com.sby.util.sse.SSEUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Random;

@Controller
@RequestMapping(value = "/sse")
public class SSEController {
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
        //return "data:{Testing：[ 1,2,3" + r.nextInt() + "]}\n\n";
        String result = "{Testing：[ "+r.nextInt()+"]}";
        return SSEUtil.result(result);
    }
}
