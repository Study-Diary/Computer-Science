package com.example.demo.proxy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MiniGameTest {

    @Test
    void gameTest(){

        MiniGame miniGame = new MiniGame();
        miniGame.setUserName("쥴리");
        miniGame.welcomeMessage();

        // 사용자 입력에 따라 게임 실행
        String userInput = "start";

        if ("start".equals(userInput)) {
            miniGame.playGame();
        }
    }
}