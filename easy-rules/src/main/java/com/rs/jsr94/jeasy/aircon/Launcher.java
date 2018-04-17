package com.rs.jsr94.jeasy.aircon;

import static com.rs.jsr94.jeasy.aircon.DecreaseTemperatureAction.decreaseTemperature;
import static com.rs.jsr94.jeasy.aircon.HighTemperatureCondition.itIsHot;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.InferenceRulesEngine;
import org.jeasy.rules.core.RuleBuilder;

public class Launcher {

    public static void main(String[] args) {
        // define facts
        Facts facts = new Facts();
        facts.put("temperature", 30);

        // define rules
        Rule airConditioningRule = new RuleBuilder()
                .name("air conditioning rule")
                .when(itIsHot())
                .then(decreaseTemperature())
                .build();
        Rules rules = new Rules();
        rules.register(airConditioningRule);

        // fire rules on known facts
        RulesEngine rulesEngine = new InferenceRulesEngine();
        rulesEngine.fire(rules, facts);
    }

}