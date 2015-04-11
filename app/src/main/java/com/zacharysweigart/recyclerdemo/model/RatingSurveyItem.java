package com.zacharysweigart.recyclerdemo.model;

import com.zacharysweigart.recyclerdemo.view.SurveyItemType;

public class RatingSurveyItem extends SurveyItem {
    private int numStars;
    private float stepSize;

    public RatingSurveyItem(String prompt) {
        super(prompt, SurveyItemType.RATING.name());
    }

    public RatingSurveyItem(String prompt, int numStars, float stepSize) {
        super(prompt, SurveyItemType.RATING.name());
        this.numStars = numStars;
        this.stepSize = stepSize;
    }

    public int getNumStars() {
        return numStars;
    }

    public void setNumStars(int numStars) {
        this.numStars = numStars;
    }

    public float getStepSize() {
        return stepSize;
    }

    public void setStepSize(float stepSize) {
        this.stepSize = stepSize;
    }
}
