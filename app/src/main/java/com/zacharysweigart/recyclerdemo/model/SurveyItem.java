package com.zacharysweigart.recyclerdemo.model;

import java.io.Serializable;
import java.util.Map;

public class SurveyItem implements Serializable {
    protected String prompt;
    protected String type;

    public SurveyItem(String prompt, String type) {
        this.prompt = prompt;
        this.type = type;
    }

    public String getPrompt() {
        return prompt;
    }

    public String getType() {
        return type;
    }
}
