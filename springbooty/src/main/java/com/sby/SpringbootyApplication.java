package com.sby;

import afu.org.checkerframework.checker.nullness.qual.Nullable;
import com.google.common.util.concurrent.*;
import com.sby.bean.BookBean;
import com.sby.guava.GuavaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.Callable;

@SpringBootApplication
@RestController
public class SpringbootyApplication{
	@Autowired
	private ListeningExecutorService listeningExecutorService;

	@Autowired
	private GuavaService guavaService;

	@Autowired
	private BookBean bookBean;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootyApplication.class, args);
	}


	@RequestMapping("/")
	public String index(){
		return "Hello Spring Boot!" + bookBean.toString();
	}


	/**
	 *
	 * @return
	 */
	@RequestMapping(value = "/guava/get")
	public String get(){
		long start = System.currentTimeMillis();
		ListenableFuture<Long> userListenableFuture = listeningExecutorService.submit(new Callable<Long>() {
			@Override
			public Long call() throws Exception {
				return guavaService.getUserList();
			}
		});

		ListenableFuture<Long> orderListenableFuture = listeningExecutorService.submit(new Callable<Long>() {
			@Override
			public Long call() throws Exception {
				return guavaService.getOrderList();
			}
		});

		ListenableFuture<Long> messageListenableFuture = listeningExecutorService.submit(new Callable<Long>() {
			@Override
			public Long call() throws Exception {
				return guavaService.getMessageList();
			}
		});

		final ListenableFuture<List<Long>> threeServicesFutures = Futures.successfulAsList(userListenableFuture,orderListenableFuture,messageListenableFuture);
		ListenableFuture<Long> listenableFuture = Futures.transformAsync(threeServicesFutures,new AsyncFunction<List<Long>,Long>(){
			@Override
			public ListenableFuture<Long> apply(@Nullable List<Long> longs) throws Exception {
				if (CollectionUtils.isEmpty(longs)){
					return null;
				}
				long resut = 0 ;
				int size = longs.size();
				for (int i = 0; i < size; i++) {
					resut += longs.get(i);
				}
				return Futures.immediateFuture(resut);
			}
		},listeningExecutorService);
		addCallBack(listenableFuture);


//		ListenableFuture<Long> addressListenableFuture = listeningExecutorService.submit(new Callable<Long>() {
//			@Override
//			public Long call() throws Exception{
//				return guavaService.getAddressList();
//			}
//		});
//
//
//		ListenableFuture fourservicesFutures = Futures.successfulAsList(threeServicesFutures,addressListenableFuture);
//
//		ListenableFuture<Long> listenableFuture2 = Futures.transformAsync(fourservicesFutures, new AsyncFunction<List<Long>, Long>() {
//			@Override
//			public ListenableFuture<Long> apply(@Nullable List<Long> longs){
//				long resut = 0 ;
//				int size = longs.size();
//				for (int i = 0; i < size; i++) {
//					resut += longs.get(i);
//				}
//				return Futures.immediateFuture(resut);
//			}
//		},listeningExecutorService);
//
//		addCallBack(listenableFuture2);

		long end = System.currentTimeMillis();
		Long time = 0L;
		String str  = "执行结果为："+time+"秒，共耗时：" + (end -start)+"毫秒";
		System.out.println(start);
		return str;
	}

	private void addCallBack(ListenableFuture<Long> listenableFuture) {
		Futures.addCallback(listenableFuture, new FutureCallback<Long>() {
			@Override
			public void onSuccess(@Nullable Long aLong) {
				System.out.println("执行成功，执行成功后的回调函数");
			}

			@Override
			public void onFailure(Throwable throwable) {
				System.out.println("执行失败,执行失败后的回调函数"+throwable.toString());
			}
		},listeningExecutorService);
	}

	/**
	 *
	 * @return
	 */
	@RequestMapping(value = "/guava/get2")
	public String get2(){
		long start = System.currentTimeMillis();
		ListenableFuture<Boolean> listenableFuture = listeningExecutorService.submit(new Callable<Boolean>() {
			@Override
			public Boolean call() throws Exception {
				Thread.sleep(5000);
				return true;
			}
		});

		Futures.addCallback(listenableFuture, new FutureCallback<Boolean>() {
			@Override
			public void onSuccess(Boolean aBoolean) {
				System.out.println("执行成功，执行成功后的回调函数");
				//此处调用对应的方法，处理正真的业务
			}
			@Override
			public void onFailure(Throwable throwable) {
				System.out.println("执行失败,执行失败后的回调函数");
			}
		},listeningExecutorService);

		long end = System.currentTimeMillis();
		Long time = 0L;
		String str  = "执行结果为："+time+"秒，共耗时：" + (end -start)+"毫秒";
		System.out.println(start);
		return str;
	}
}
