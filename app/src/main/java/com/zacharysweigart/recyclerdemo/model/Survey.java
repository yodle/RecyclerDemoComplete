package com.zacharysweigart.recyclerdemo.model;

import java.io.Serializable;
import java.util.List;

public class Survey implements Serializable{
    String name;
    List<SurveyItem> surveyItems;

    public Survey(String name) {
        this.name = name;
    }

    public Survey(List<SurveyItem> surveyItems, String name) {
        this.surveyItems = surveyItems;
        this.name = name;
    }

    public List<SurveyItem> getSurveyItems() {
        return surveyItems;
    }

    public void setSurveyItems(List<SurveyItem> surveyItems) {
        this.surveyItems = surveyItems;
    }

    public String getName() {
        return name;
    }
}
