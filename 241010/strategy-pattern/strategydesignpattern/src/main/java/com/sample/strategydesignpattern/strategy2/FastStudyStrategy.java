package com.sample.strategydesignpattern.strategy2;

import com.sample.strategydesignpattern.strategy.Context;

public class FastStudyStrategy implements StudyStrategy {

    @Override
    public void study(Context context) {
        System.out.println("Studying fast");
        int needTime = (context.getExam().targetScore - context.getExam().previousScore) * context.getNeedTimeForOneScore(); // 1점 올리는 데 10시간 필요
        int needDays = needTime / 10; // 하루에 10시간 공부
        System.out.println("Need time: " + needDays + " need days: " + needDays);

    }
}