package com.derrick.demo.test;

import com.derrick.demo.entity.Demo;
import com.derrick.demo.service.DemoService;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

/**
 * Created by Derrick on 2016/4/5.
 */
public class Test {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(Test.class.getName());
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-base.xml");
        DemoService demoService = (DemoService) context.getBean("demoService");
        Demo demo = new Demo();
        Random random = new Random();
        Long id = random.nextLong();
        demo.setId(id);
        demo.setName("tom");
        demo.setPosition("Manager");
        demoService.save(demo);
        LOG.debug(demoService.find(1L).toString());
    }
}
