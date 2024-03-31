package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.SuperContraGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;



public class App02HelloWorldSpring {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));
        System.out.println(context.getBean("person"));
        System.out.println(context.getBean("address2"));
        //System.out.println(context.getBean("person3Parameters"));
        System.out.println(context.getBean("person4Parameters"));
        System.out.println("-----------------------------------------");
        System.out.println(context.getBean(HelloWorldConfiguration.Test.class).jump());

       // Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        //context.getBeanDefinitionNames();
       // System.out.println(context.getBean(Address.class));
    }
}
