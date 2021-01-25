package com.lmy.blog;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author lmy
 * @email 2818026900@qq.com
 */
@ServletComponentScan
@EnableSwagger2Doc
@SpringBootApplication(scanBasePackages = "com.lmy.blog")
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

}
