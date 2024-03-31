package com.in28minutes.learnspringframework.examples.a2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


interface GameConsole{
    void jump();
}

@Component
class Mario implements GameConsole{
    @Override
    public void jump() {
    }
    public String toString(){
        return "mario";
    }
}

@Component("luigi")
class PacMan implements GameConsole{
    @Override
    public void jump() {

    }

    public String toString(){
        return "pacMan";
    }
}

@Component
class Test{
    @Autowired
    @Qualifier("luigi")
    GameConsole mario;

    public String test(){
        System.out.println(mario);
        return null;
    }
}

@Configuration
@ComponentScan
public class DeepInjection {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(com.in28minutes.learnspringframework.examples.a2.DeepInjection.class)){

            System.out.println(context.getBean(Test.class).test());
        };
    }
}