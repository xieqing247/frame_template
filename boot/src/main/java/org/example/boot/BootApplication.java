package org.example.boot;

import org.example.boot.utils.AopTargetUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;


@SpringBootApplication
public class BootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BootApplication.class, args);
        String[] beans = context.getBeanNamesForAnnotation(Controller.class);
        for (String bean : beans) {
            System.out.println(bean);
        }

        List<Object> list = context.getBeansWithAnnotation(Controller.class).values().parallelStream().map(e -> {
            try {
                return AopTargetUtils.getTarget(e);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return e;
        }).collect(Collectors.toList());


        for (Object o : list) {
            System.out.println(o);
        }
    }

}
