package com.rs.jsr94.jeasy.fizzbuzz;

import org.jeasy.rules.support.UnitRuleGroup;

public class FizzBuzzRule extends UnitRuleGroup {

    public FizzBuzzRule(Object... rules) {
        for (Object rule : rules) {
            addRule(rule);
        }
    }

    @Override
    public int getPriority() {
        return 0;
    }
}
