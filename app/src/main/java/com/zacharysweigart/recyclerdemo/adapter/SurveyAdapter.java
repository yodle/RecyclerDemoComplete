package com.zacharysweigart.recyclerdemo.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zacharysweigart.recyclerdemo.model.RadioSurveyItem;
import com.zacharysweigart.recyclerdemo.model.RatingSurveyItem;
import com.zacharysweigart.recyclerdemo.model.SurveyItem;
import com.zacharysweigart.recyclerdemo.model.TextSurveyItem;
import com.zacharysweigart.recyclerdemo.view.RadioSurveyItemViewHolder;
import com.zacharysweigart.recyclerdemo.view.RatingSurveyItemViewHolder;
import com.zacharysweigart.recyclerdemo.view.SurveyItemType;
import com.zacharysweigart.recyclerdemo.view.TextSurveyItemViewHolder;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SurveyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Activity mActivity;
    private List<SurveyItem> mDataset;

    public SurveyAdapter(Activity activity, List<SurveyItem> dataset) {
        this.mActivity = activity;
        this.mDataset = dataset;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mActivity);
        SurveyItemType type = SurveyItemType.fromPosition(viewType);
        View v = inflater.inflate(type.layout, viewGroup, false);
        return SurveyItemType.createViewHolder(type, v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        SurveyItemType type = SurveyItemType.fromName(mDataset.get(position).getType());
        switch (type) {
            case TEXT:
                ((TextSurveyItemViewHolder)viewHolder).setContent((TextSurveyItem)mDataset.get(position));
                break;
            case RADIO:
                ((RadioSurveyItemViewHolder)viewHolder).setContent((RadioSurveyItem)mDataset.get(position));
                break;
            case RATING:
                ((RatingSurveyItemViewHolder)viewHolder).setContent((RatingSurveyItem)mDataset.get(position));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override
    public int getItemViewType(int position) {
        SurveyItemType type = SurveyItemType.fromName(mDataset.get(position).getType());
        return type.position;
    }
}
