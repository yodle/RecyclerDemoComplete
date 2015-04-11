package com.zacharysweigart.recyclerdemo.model;

import com.zacharysweigart.recyclerdemo.view.SurveyItemType;

import java.util.List;

public class RadioSurveyItem extends SurveyItem {
    private List<String> options;

    public RadioSurveyItem(String prompt) {
        super(prompt, SurveyItemType.RADIO.name());
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
