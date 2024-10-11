package com.sample.strategydesignpattern.flyweight;

import com.sample.strategydesignpattern.Exam;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlyweightContextTest {

    @Test
    void testFlyweightWhenMasterStrategy(){
        Exam exam = new Exam("한지원", 100, 50);
        FlyweightContext context = new FlyweightContext();
        context.setExam(exam);
        context.setNeedTimeForOneScore(30);
        context.setStudyStrategy("Master");


        Exam exam2 = new Exam("홍길동", 90, 50);
        FlyweightContext context2 = new FlyweightContext();
        context2.setExam(exam2);
        context2.setNeedTimeForOneScore(20);
        context2.setStudyStrategy("Master");

        // 같은 주소 값을 갖는 것을 검증
        assertEquals(context.getStudyStrategyHashCode(), context2.getStudyStrategyHashCode());

    }

}