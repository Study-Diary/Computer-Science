package com.example.demo.proxy;

import java.lang.reflect.InvocationTargetException;

public class MiniGameProxy implements CanMiniGame {

//    private MiniGame realMiniGame;
    private CanMiniGame realMiniGame;
    private String className; // Real MiniGame 객체의 클래스 이름
    private String userName;

    public MiniGameProxy(String className) {
        this.realMiniGame = null; // 객체 생성을 지연
        this.className = className;
        this.userName = "null";
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
            System.out.println(userName+ "님, "+ className + " 에 오신 것을 환영합니다 : ) ");
        }else{
            realMiniGame.welcomeMessage();
        }
    }

    @Override
    public void playGame() {
        if (realMiniGame == null){
            try {
                realMiniGame = (CanMiniGame) Class.forName("com.example.demo.proxy."+ className).getDeclaredConstructor().newInstance();
            } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                     InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
        realMiniGame.playGame();
    }
}
