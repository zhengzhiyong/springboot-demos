package com.sby.util.sse;

public class SSEUtil {


    //SSE返回数据格式是固定的以data:开头，以\n\n结束
    public static String result(String res){
        return "data:" + res + "\n\n";
    }
}
