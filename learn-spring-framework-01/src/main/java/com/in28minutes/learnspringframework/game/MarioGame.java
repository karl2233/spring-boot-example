package com.in28minutes.learnspringframework.game;

public class MarioGame implements GamingConsole{
    public void up() {
        System.out.println("Jump");
    }
    public void down(){
        System.out.println("Go into a whole");
    }

    public void left(){
        System.out.println("Go back");
    }

    public void right(){
        System.out.println("Accelarate");
    }
}
