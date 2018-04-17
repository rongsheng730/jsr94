package com.rs.jsr94.jeasy.web;

import javax.servlet.http.HttpServletRequest;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

@Rule
public class SuspiciousRequestRule {

    static final String SUSPICIOUS = "suspicious";

    @Condition
    public boolean isSuspicious(@Fact("request") HttpServletRequest request) {
        // criteria of suspicious could be based on ip, user-agent, etc.
        // here for simplicity, it is based on the presence of a request parameter 'suspicious'
        return request.getParameter(SUSPICIOUS) != null;
    }
    
    @Action
    public void setSuspicious(@Fact("request") HttpServletRequest request) {
        request.setAttribute(SUSPICIOUS, true);
    }
}