package com.zacharysweigart.recyclerdemo.model;

import com.zacharysweigart.recyclerdemo.view.SurveyItemType;

public class TextSurveyItem extends SurveyItem {
    public TextSurveyItem(String prompt) {
        super(prompt, SurveyItemType.TEXT.name());
    }
}
