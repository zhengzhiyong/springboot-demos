package com.sby.guava;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;

@Component
public class GuavaListeningExecutors {

 @Bean
 public ListeningExecutorService createListeningExecutorService(){
    return MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(4));
 }
}
