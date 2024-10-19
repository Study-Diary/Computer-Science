package com.sample.strategydesignpattern.strategy;

public class MasterStudyStrategy implements StudyStrategy {

    @Override
    public void study(int targetScore, int previousScore, int needTimeForOneScore, int workHours) {
        System.out.println("Studying master");
        int needTime = (targetScore - previousScore) * needTimeForOneScore;
        int needDays = needTime / 6; // 하루에 6시간 공부
        System.out.println("Need time: " + needDays + " need days: " + needDays);
    }
}
