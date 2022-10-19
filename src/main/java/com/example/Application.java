package com.example;


import com.example.service.IMetier;
import com.example.service.SecurityContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = {"com.example"})
public class Application {
    public static void main(String[] args) {
        try {

            SecurityContext.authenticate("root", "1234", new String[]{"USER", "ADMIN"});

            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);

            IMetier metier = applicationContext.getBean(IMetier.class);

            System.out.println("*******************************************");
            System.out.println(metier.getClass().getName());
            System.out.println("*******************************************");


            metier.process();
            System.out.println("result : " + metier.compute());


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
