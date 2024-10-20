package com.example.demo.proxy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MiniGameProxyTest {

    @Test
    void miniGameTestProxy(){
        CanMiniGame miniGame = new MiniGameProxy("MiniGame");
        miniGame.setUserName("쥴리"); // 실제 객체는 생성되지 않았다.
        miniGame.welcomeMessage();

        // 사용자 입력에 따라 게임 실행
        String userInput = "start";

        if ("start".equals(userInput)) {
            miniGame.playGame();
        }
    }

    @Test
    void onlyWelcomeProxy(){
        CanMiniGame miniGame = new MiniGameProxy("MiniGame");
        miniGame.setUserName("쥴리"); // 실제 객체는 생성되지 않았다.
        miniGame.welcomeMessage();
    }

    @Test
    void proxyTestWhenVariousMiniGame(){
        CanMiniGame miniGame = new MiniGameProxy("PuzzleMiniGame");
        miniGame.setUserName("쥴리"); // 실제 객체는 생성되지 않았다.
        miniGame.welcomeMessage();
        miniGame.playGame();

        CanMiniGame miniGame2 = new MiniGameProxy("BubbleMiniGame");
        miniGame2.setUserName("나띠"); // 실제 객체는 생성되지 않았다.
        miniGame2.welcomeMessage();
        miniGame2.playGame();

        CanMiniGame miniGame3 = new MiniGameProxy("MarioMiniGame");
        miniGame3.setUserName("벨"); // 실제 객체는 생성되지 않았다.
        miniGame3.welcomeMessage();
        miniGame3.playGame();
    }

}