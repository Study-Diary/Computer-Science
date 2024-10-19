package com.sample.strategydesignpattern;

public class Exam {
    String name;
    public int targetScore;
    public int previousScore;

    public Exam(String name, int targetScore, int previousScore) {
        this.name = name;
        this.targetScore = targetScore;
        this.previousScore = previousScore;
    }
}
