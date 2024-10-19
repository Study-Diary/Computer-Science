package com.sample.strategydesignpattern.strategy2;

import com.sample.strategydesignpattern.strategy.Context;

public class MasterStudyStrategy implements StudyStrategy {

    @Override
    public void study(Context context) {
        System.out.println("Studying master");
        int needTime = (context.getExam().targetScore - context.getExam().previousScore) * context.getNeedTimeForOneScore();
        int needDays = needTime / 6; // 하루에 6시간 공부
        System.out.println("Need time: " + needDays + " need days: " + needDays);

    }
}
