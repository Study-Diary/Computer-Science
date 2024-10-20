package com.example.demo.proxy;

public class BubbleMiniGame implements CanMiniGame {

    private String userName;

    public BubbleMiniGame() {
        initialWork();
    }

    private void initialWork() {
        try {
            Thread.sleep(1000);
            System.out.println("Bubble 미니 게임 초기화 작업이 완료됐습니다.");
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
        System.out.println(userName+ "님, Bubble 미니 게임에 오신 것을 환영합니다 : ) ");
    }

    @Override
    public void playGame() {
        System.out.println("Bubble 미니 게임을 시작합니다.");
    }
}