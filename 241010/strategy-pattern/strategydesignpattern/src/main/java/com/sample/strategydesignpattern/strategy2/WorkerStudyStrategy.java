package com.sample.strategydesignpattern.strategy2;

import com.sample.strategydesignpattern.strategy.Context;

public class WorkerStudyStrategy implements StudyStrategy {

    @Override
    public void study(Context context) {
        System.out.println("Studying for worker");
        int needTime = (context.getExam().targetScore - context.getExam().previousScore) * context.getNeedTimeForOneScore();
        int needDays = needTime / (12 - context.getWorkHours()); // 하루 공부 가능 시간: 12시간에서 근무 시간을 뺀다.
        System.out.println("Need time: " + needDays + " need days: " + needDays);
    }
}
