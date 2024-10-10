package com.sample.strategydesignpattern.flyweight;

import com.sample.strategydesignpattern.strategy.FastStudyStrategy;
import com.sample.strategydesignpattern.strategy.MasterStudyStrategy;
import com.sample.strategydesignpattern.strategy.StudyStrategy;
import com.sample.strategydesignpattern.strategy.WorkerStudyStrategy;

import java.util.HashMap;
import java.util.Map;

public class StudyStrategyFactory {

    private static final Map<String, StudyStrategy> studyStrategyMap = new HashMap<>();

    private StudyStrategyFactory() {
    }
    public synchronized static StudyStrategy getStudyStrategy(String strategyType) {
        if (!studyStrategyMap.containsKey(strategyType)) {
            switch (strategyType) {
                case "Fast":
                    studyStrategyMap.put(strategyType, new FastStudyStrategy());
                    break;
                case "Master":
                    studyStrategyMap.put(strategyType, new MasterStudyStrategy());
                    break;
                case "Worker":
                    studyStrategyMap.put(strategyType, new WorkerStudyStrategy());
                    break;
            }
        }
        return studyStrategyMap.get(strategyType);
    }
}
