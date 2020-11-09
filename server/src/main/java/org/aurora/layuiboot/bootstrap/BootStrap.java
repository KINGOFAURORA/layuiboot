package org.aurora.layuiboot.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhangjian
 * @date 2020/11/9 9:50
 */
@SpringBootApplication(scanBasePackages = {"org.aurora.layuiboot"})
public class BootStrap {
    public static void main(String[] args) {
        SpringApplication.run(BootStrap.class, args);
    }
}
