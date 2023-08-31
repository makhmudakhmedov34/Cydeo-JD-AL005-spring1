package com.cydeo.stereotype_annotation;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigCourse.class);

        Java java= context.getBean(Java.class);
        java.getTeachingHours();

        Agile agile= context.getBean(Agile.class);
        agile.getTeachingHours();

        Selenium selenium= context.getBean(Selenium.class);
        selenium.getTeachingHours();




    }
}
