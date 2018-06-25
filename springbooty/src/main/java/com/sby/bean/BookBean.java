package com.sby.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by zheng on 2018/6/13.
 */
@Component
@ConfigurationProperties(prefix = "book")
@PropertySource("classpath:book.properties")
public class BookBean {

    @Value("${book.name}")
    private String name;

    @Value("${book.author}")
    private String author;

    @Value("${book.price}")
    private String price;

    @Value("${book.pinyin}")
    private String pinyin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    @Override
    public String toString(){
        return "The BookName is "+this.getName()+" ,and Book Author is "+this.getAuthor()+"  ,and the Book Price is "+ this.getPrice()+" ,and the Pinyin is "+this.getPinyin();
    }
}
