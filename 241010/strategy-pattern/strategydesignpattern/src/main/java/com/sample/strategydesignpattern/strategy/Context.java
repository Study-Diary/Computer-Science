package com.sample.strategydesignpattern.strategy;

import com.sample.strategydesignpattern.Exam;

public class Context {
    private Exam exam;
    private StudyStrategy studyStrategy;
    private int needTimeForOneScore;
    private int workHours;

    public void setStudyStrategy(StudyStrategy studyStrategy) {
        this.studyStrategy = studyStrategy;
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

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public Exam getExam() {
        return exam;
    }

    public StudyStrategy getStudyStrategy() {
        return studyStrategy;
    }

    public int getNeedTimeForOneScore() {
        return needTimeForOneScore;
    }

    public int getWorkHours() {
        return workHours;
    }

    public int getStudyStrategyHashCode() {
        return studyStrategy.hashCode();
    }
}
