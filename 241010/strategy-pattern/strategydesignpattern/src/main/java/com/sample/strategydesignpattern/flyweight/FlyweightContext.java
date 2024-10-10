package com.sample.strategydesignpattern.flyweight;


import com.sample.strategydesignpattern.Exam;
import com.sample.strategydesignpattern.strategy.StudyStrategy;

public class FlyweightContext {
    private Exam exam;
    private StudyStrategy studyStrategy;
    private int needTimeForOneScore;
    private int workHours;

    public void setStudyStrategy(String studyType) {
        this.studyStrategy = StudyStrategyFactory.getStudyStrategy(studyType);
    }

    public void study() {
        studyStrategy.study(exam.targetScore, exam.previousScore, needTimeForOneScore, workHours);
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public void setNeedTimeForOneScore(int needTimeForOneScore) {
        this.needTimeForOneScore = needTimeForOneScore;
    }

    public int getStudyStrategyHashCode() {
        return studyStrategy.hashCode();
    }
}
