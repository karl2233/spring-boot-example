package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.SuperContraGame;

public class AppGamingBasic {
    public static void main(String[] args) {
        var marioGame = new SuperContraGame();
        var gameRunner = new GameRunner(marioGame);
        gameRunner.run();
    }
}
