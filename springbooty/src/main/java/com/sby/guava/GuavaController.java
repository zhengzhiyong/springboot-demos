package com.sby.guava;//package com.sby.guava;
//
//import com.google.common.util.concurrent.FutureCallback;
//import com.google.common.util.concurrent.Futures;
//import com.google.common.util.concurrent.ListenableFuture;
//import com.google.common.util.concurrent.ListeningExecutorService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.concurrent.Callable;
//
//@Controller
//@RequestMapping("/guava")
//public class GuavaController {
//
//    @Autowired
//    private ListeningExecutorService listeningExecutorService;
//    /**
//     *
//     * @return
//     */
//    @RequestMapping(value = "/get")
//    public void get(){
//        long start = System.currentTimeMillis();
//        ListenableFuture<Boolean> listenableFuture = listeningExecutorService.submit(new Callable<Boolean>() {
//            @Override
//            public Boolean call() throws Exception {
//                Thread.sleep(5000);
//                return true;
//            }
//        });
//
//        Futures.addCallback(listenableFuture, new FutureCallback<Boolean>() {
//            @Override
//            public void onSuccess(Boolean aBoolean) {
//                System.out.println("执行成功，执行成功后的回调函数");
//            }
//
//            @Override
//            public void onFailure(Throwable throwable) {
//                System.out.println("执行失败,执行失败后的回调函数");
//            }
//        },listeningExecutorService);
//
//        long end = System.currentTimeMillis();
//        Long time = 0L;
//        String str  = "执行结果为："+time+"秒，共耗时：" + (end -start)+"毫秒";
//        System.out.println(start);
//        return;
//    }
//}
