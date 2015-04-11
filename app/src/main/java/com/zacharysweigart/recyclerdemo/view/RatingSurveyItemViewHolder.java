package com.zacharysweigart.recyclerdemo.view;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.zacharysweigart.recyclerdemo.R;
import com.zacharysweigart.recyclerdemo.model.RatingSurveyItem;
import com.zacharysweigart.recyclerdemo.model.SurveyItem;

import java.util.Set;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class RatingSurveyItemViewHolder extends RecyclerView.ViewHolder {

    @InjectView(R.id.rating_survey_item_prompt)
    TextView prompt;

    @InjectView(R.id.rating_survey_item_value)
    RatingBar value;

    public RatingSurveyItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.inject(this, itemView);
    }

    public void setContent(RatingSurveyItem ratingSurveyItem) {
        prompt.setText(ratingSurveyItem.getPrompt());

        value.setNumStars(ratingSurveyItem.getNumStars());
        value.setStepSize(ratingSurveyItem.getStepSize());
    }
}
