package com.zacharysweigart.recyclerdemo.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.zacharysweigart.recyclerdemo.R;
import com.zacharysweigart.recyclerdemo.model.SurveyItem;
import com.zacharysweigart.recyclerdemo.model.TextSurveyItem;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class TextSurveyItemViewHolder extends RecyclerView.ViewHolder {

    @InjectView(R.id.text_survey_item_prompt)
    TextView prompt;

    @InjectView(R.id.text_survey_item_value)
    EditText value;

    public TextSurveyItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.inject(this, itemView);
    }

    public void setContent(TextSurveyItem textSurveyItem) {
        prompt.setText(textSurveyItem.getPrompt());
    }
}
