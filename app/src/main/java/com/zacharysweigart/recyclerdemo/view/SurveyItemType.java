package com.zacharysweigart.recyclerdemo.view;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zacharysweigart.recyclerdemo.R;

public enum SurveyItemType {
    TEXT(0, R.layout.text_survey_item),
    RADIO(1, R.layout.radio_survey_item),
    RATING(2, R.layout.rating_survey_item);

    public Integer position;
    public Integer layout;

    SurveyItemType(int position, Integer layout) {
        this.layout = layout;
        this.position = position;
    }

    public static SurveyItemType fromName(String name) throws IllegalArgumentException{
        for(SurveyItemType surveyItemType : SurveyItemType.values()) {
            if(surveyItemType.name().equals(name)) {
                return surveyItemType;
            }
        }
        throw new IllegalArgumentException("Unable to find JobDetailViewType with position: " + name);
    }

    public static SurveyItemType fromPosition(int position) throws IllegalArgumentException{
        for(SurveyItemType surveyItemType : SurveyItemType.values()) {
            if(surveyItemType.position == position) {
                return surveyItemType;
            }
        }
        throw new IllegalArgumentException("Unable to find JobDetailViewType with position: " + position);
    }

    public static RecyclerView.ViewHolder createViewHolder(SurveyItemType surveyItemType, View v) {
        switch (surveyItemType) {
            case TEXT:
                return new TextSurveyItemViewHolder(v);
            case RADIO:
                return new RadioSurveyItemViewHolder(v);
            case RATING:
                return new RatingSurveyItemViewHolder(v);
        }
        throw new IllegalArgumentException("Cannot create a view holder for: " + surveyItemType.name());
    }
}
