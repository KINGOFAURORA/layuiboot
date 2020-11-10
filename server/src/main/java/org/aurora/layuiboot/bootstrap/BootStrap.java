package org.aurora.layuiboot.bootstrap;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhangjian
 * @date 2020/11/9 9:50
 */
@MapperScan("org.aurora.layuiboot.dao")
@SpringBootApplication(scanBasePackages = {"org.aurora.layuiboot"})
public class BootStrap {
    public static void main(String[] args) {
        SpringApplication.run(BootStrap.class, args);
    }
}
