package com.example.demo.proxy;

public class MiniGame implements canMiniGame {

    private String userName;

    public MiniGame() {
        initialWork();
    }
    public MiniGame(String userName) {
        this.userName = userName;
        initialWork();
    }

    private void initialWork() {
        try {
            Thread.sleep(3000);
            System.out.println("MiniGame 초기화 작업이 완료됐습니다.");
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
        System.out.println(userName+ "님, MiniGame 에 오신 것을 환영합니다 : ) ");
    }

    @Override
    public void playGame() {
        System.out.println("START!!");
    }
}
