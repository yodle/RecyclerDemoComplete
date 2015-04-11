package com.zacharysweigart.recyclerdemo.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zacharysweigart.recyclerdemo.R;
import com.zacharysweigart.recyclerdemo.activity.SurveyActivity;
import com.zacharysweigart.recyclerdemo.model.Survey;
import com.zacharysweigart.recyclerdemo.model.SurveyItem;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SurveyListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Activity mActivity;
    private List<Survey> mDataset;

    public SurveyListAdapter(Activity activity, List<Survey> dataset) {
        this.mActivity = activity;
        this.mDataset = dataset;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mActivity);
        View v = inflater.inflate(R.layout.survey_list_row, viewGroup, false);
        return new SurveyItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ((SurveyItemViewHolder)viewHolder).setContent(mDataset.get(position), mActivity);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class SurveyItemViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.survey_list_row_text)
        TextView rowTextView;

        View itemView;

        public SurveyItemViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
            this.itemView = itemView;
        }

        public void setContent(final Survey survey, final Activity activity) {
            rowTextView.setText(survey.getName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.startActivity(SurveyActivity.getIntent(activity, survey));
                }
            });
        }
    }
}
