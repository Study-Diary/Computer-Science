package com.sample.strategydesignpattern;

import com.sample.strategydesignpattern.flyweight.FlyweightContext;
import com.sample.strategydesignpattern.strategy.Context;
import com.sample.strategydesignpattern.strategy.MasterStudyStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class StudyStrategyTest {

    @Test
    void successWhenMasterStrategy(){
        Exam exam = new Exam("한지원", 100, 50);
        Context context = new Context();
        context.setExam(exam);
        context.setNeedTimeForOneScore(30);
        context.setStudyStrategy(new MasterStudyStrategy());
        context.study();
    }

    @Test
    void inefficientWhenStrategy(){

        Exam exam = new Exam("한지원", 100, 50);
        Context context = new Context();
        context.setExam(exam);
        context.setNeedTimeForOneScore(30);
        context.setStudyStrategy(new MasterStudyStrategy());
        context.study();

        Exam exam2 = new Exam("홍길동", 90, 50);
        Context context2 = new Context();
        context2.setExam(exam2);
        context2.setNeedTimeForOneScore(20);
        context2.setStudyStrategy(new MasterStudyStrategy());

        // 다른 주소 값을 갖는 것을 검증
        assertNotEquals(context.getStudyStrategyHashCode(), context2.getStudyStrategyHashCode());
    }

    @Test
    void successWhenNoneStrategy() {
        Exam exam = new Exam("한지원", 100, 50);

        String strategyType = "Master";
        int targetScore = exam.targetScore;
        int previousScore = exam.previousScore;
        int needTime = 0;
        int needDays = 0;

        switch (strategyType) {
            case "Master":
                System.out.println("Studying master");
                needTime = (targetScore - previousScore) * 30; // 1점 올리는 데 30시간 필요
                needDays = needTime / 6; // 하루에 6시간 공부
                System.out.println("Need time: " + needDays + " need days: " + needDays);
                break;
            case "Fast":
                System.out.println("Studying fast");
                needTime = (targetScore - previousScore) * 10; // 1점 올리는 데 10시간 필요
                needDays = needTime / 10; // 하루에 10시간 공부
                System.out.println("Need time: " + needDays + " need days: " + needDays);
            case "Worker":
                System.out.println("Studying for worker");
                needTime = (targetScore - previousScore) * 10; // 1점 올리는 데 10시간 필요
                needDays = needTime / 2; // 하루에 6시간 공부
                System.out.println("Need time: " + needDays + " need days: " + needDays);
            default:
                throw new IllegalArgumentException("Unknown strategy type: " + strategyType);
        }
    }

}