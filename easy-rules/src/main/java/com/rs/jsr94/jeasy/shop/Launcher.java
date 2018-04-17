package com.rs.jsr94.jeasy.shop;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.mvel.MVELRule;
import org.jeasy.rules.mvel.MVELRuleFactory;

public class Launcher {

    public static void main(String[] args) throws FileNotFoundException {
        //create a person instance (fact)
        Person tom = new Person("Tom", 14);
        Facts facts = new Facts();
        facts.put("person", tom);

        // create rules
        MVELRule ageRule = new MVELRule()
                .name("age rule")
                .description("Check if person's age is > 18 and marks the person as adult")
                .priority(1)
                .when("person.age > 18")
                .then("person.setAdult(true)");
        MVELRule alcoholRule = MVELRuleFactory.createRuleFrom(new FileReader("/Users/rongsheng/gitsrc/jsr94/easy-rules/src/main/java/com/rs/jsr94/jeasy/shop/alcohol-rule.yml"));

        // create a rule set
        Rules rules = new Rules();
        rules.register(ageRule);
        rules.register(alcoholRule);

        //create a default rules engine and fire rules on known facts
        RulesEngine rulesEngine = new DefaultRulesEngine();

        System.out.println("Tom: Hi! can I have some Vodka please?");
        rulesEngine.fire(rules, facts);
    }

}
