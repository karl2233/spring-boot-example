package com.in28minutes.learnspringframework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


record Person(String name,int age,Address address){};
record Address(String firstLine,String city){};
@Configuration
public class HelloWorldConfiguration {

    @Component("test")
    class Test{
        @Autowired
        @Qualifier("person6")
        Person person5;

        public String jump(){
            System.out.println(person5.address());
            return "it worked";
        }
    }

    @Bean
    public String name(){
        return "Ranga";
    }
    @Bean
    public int age(){
        return 15;
    }
    @Bean
    public Person person(){
        var person = new Person("Ravi",20,new Address("Main Street","Utrecht"));
        return person;
    }
    @Bean
    public Person person2Methodcall(){
        return new Person(name(),age(),address());
    }

    @Bean(name="person6")
    public Person person3Parameters(String name, int age, @Qualifier("address3qualifier") Address address){
        return new Person(name,age,address);
    }

    @Bean
    public Person person4Parameters(String name,int age,Address address3){
        return new Person(name,age,address3);
    }
    @Bean(name="address2")
    public Address address(){
        var address = new Address("Baker Street","Londone");
        return address;
    }
    @Bean(name="address3")
    @Qualifier("address3qualifier")
    public Address address3(){
        var address = new Address("Baker Street","Londone");
        return address;
    }
}
