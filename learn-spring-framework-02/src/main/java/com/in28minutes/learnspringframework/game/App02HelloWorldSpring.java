package com.in28minutes.learnspringframework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.in28minutes.learnspringframework.game")
public class App02HelloWorldSpring {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(App02HelloWorldSpring.class)){
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        };
    }
}
