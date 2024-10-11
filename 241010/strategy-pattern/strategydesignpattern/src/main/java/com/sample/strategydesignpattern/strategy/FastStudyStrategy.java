package com.sample.strategydesignpattern.strategy;

public class FastStudyStrategy implements StudyStrategy {

    @Override
    public void study(int targetScore, int previousScore, int needTimeForOneScore, int workHours) {
        System.out.println("Studying fast");
        int needTime = (targetScore - previousScore) * needTimeForOneScore; // 1점 올리는 데 10시간 필요
        int needDays = needTime / 10; // 하루에 10시간 공부
        System.out.println("Need time: " + needDays + " need days: " + needDays);
    }
}