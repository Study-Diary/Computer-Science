package com.example.demo.proxy;

public class MarioMiniGame implements CanMiniGame {

    private String userName;

    public MarioMiniGame() {
        initialWork();
    }

    private void initialWork() {
        try {
            System.out.println("Mario 미니 게임 초기화 작업은 조금 더 오래 걸립니다. 조금만 기다려 주세요!");
            Thread.sleep(20000);
            System.out.println("Mario 미니 게임 초기화 작업이 완료됐습니다.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void welcomeMessage() {
        System.out.println(userName+ "님, Mario 미니 게임에 오신 것을 환영합니다 : ) ");
    }

    @Override
    public void playGame() {
        System.out.println("Mario 미니 게임을 시작합니다.");
    }
}
