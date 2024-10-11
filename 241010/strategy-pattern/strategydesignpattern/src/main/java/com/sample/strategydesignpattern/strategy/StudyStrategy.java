package com.sample.strategydesignpattern.strategy;

public interface StudyStrategy {

    void study(int targetScore, int previousScore, int needTimeForOneScore, int workHours);
}
