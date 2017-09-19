package com.xuanwu.springboot.multidatasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @Decription  a simple multiple datasource demo for SpringBoot and MyBatis
 * @author Chunyan.Liu
 * @Date 2017-09-19 16:03
 */
@SpringBootApplication
public class Application{
    public static void main( String[] args ) throws Exception{
    	SpringApplication.run(Application.class, args);
    }
}
