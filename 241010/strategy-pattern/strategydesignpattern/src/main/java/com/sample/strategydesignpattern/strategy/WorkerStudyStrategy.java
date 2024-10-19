package com.sample.strategydesignpattern.strategy;

public class WorkerStudyStrategy implements StudyStrategy {

    @Override
    public void study(int targetScore, int previousScore, int needTimeForOneScore, int workHours) {
        System.out.println("Studying for worker");
        int needTime = (targetScore - previousScore) * needTimeForOneScore;
        int needDays = needTime / (12 - workHours); // 하루 공부 가능 시간: 12시간에서 근무 시간을 뺀다.
        System.out.println("Need time: " + needDays + " need days: " + needDays);
    }
}
