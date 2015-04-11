package com.zacharysweigart.recyclerdemo.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.zacharysweigart.recyclerdemo.R;
import com.zacharysweigart.recyclerdemo.model.RadioSurveyItem;
import com.zacharysweigart.recyclerdemo.model.SurveyItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class RadioSurveyItemViewHolder extends RecyclerView.ViewHolder {

    @InjectView(R.id.radio_survey_item_prompt)
    TextView prompt;

    @InjectView(R.id.radio_survey_item_value)
    RadioGroup value;

    private Context mContext;

    public RadioSurveyItemViewHolder(View itemView) {
        super(itemView);
        mContext = itemView.getContext();
        ButterKnife.inject(this, itemView);
    }

    public void setContent(RadioSurveyItem radioButtonSurveyItem) {
        prompt.setText(radioButtonSurveyItem.getPrompt());

        List<String> options = radioButtonSurveyItem.getOptions();
        for(String option : options) {
            RadioButton radioButton = new RadioButton(mContext);
            radioButton.setText(option);
            value.addView(radioButton);
        }
    }

}
