package com.example.demo.proxy;

public class MiniGameProxy implements CanMiniGame {

    private MiniGame realMiniGame;

    private String userName;

    public MiniGameProxy() {
        realMiniGame = null; // 객체 생성을 지연
        userName = "null";
    }

    @Override
    public void setUserName(String userName) {
        if (realMiniGame == null) {
            this.userName = userName;
        }else{
            realMiniGame.setUserName(userName);
        }
    }

    @Override
    public void welcomeMessage() {
        if (realMiniGame == null){
            System.out.println(userName+ "님, MiniGame 에 오신 것을 환영합니다 : ) ");
        }else{
            realMiniGame.welcomeMessage();
        }
    }

    @Override
    public void playGame() {
        if (realMiniGame == null){
            realMiniGame = new MiniGame(userName);
        }
        realMiniGame.playGame();
    }
}
