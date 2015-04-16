package com.zacharysweigart.recyclerdemo.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.RadioGroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.zacharysweigart.recyclerdemo.R;
import com.zacharysweigart.recyclerdemo.adapter.SurveyListAdapter;
import com.zacharysweigart.recyclerdemo.model.RadioSurveyItem;
import com.zacharysweigart.recyclerdemo.model.RatingSurveyItem;
import com.zacharysweigart.recyclerdemo.model.Survey;
import com.zacharysweigart.recyclerdemo.model.SurveyItem;
import com.zacharysweigart.recyclerdemo.model.TextSurveyItem;
import com.zacharysweigart.recyclerdemo.util.SurveyItemDeserializer;
import com.zacharysweigart.recyclerdemo.view.SurveyItemType;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class SurveyListActivity extends ActionBarActivity {
    @InjectView(R.id.survey_list_recycler_view)
    RecyclerView surveyListRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_list);
        ButterKnife.inject(this);

        String appString = "[{\"name\":\"First Survey\",\"surveyItems\":[{\"prompt\":\"Name\",\"type\":\"Text\"},{\"prompt\":\"Age\",\"type\":\"Text\"},{\"options\":[\"Male\",\"Female\"],\"prompt\":\"Gender\",\"type\":\"Radio\"},{\"numStars\":5,\"stepSize\":0.5,\"prompt\":\"Rating\",\"type\":\"Rating\"}]},{\"name\":\"Second Survey\",\"surveyItems\":[{\"prompt\":\"What year will you graduate\",\"type\":\"Text\"},{\"prompt\":\"What major are you pursuing\",\"type\":\"Text\"},{\"options\":[\"Grad school\",\"Job\"],\"prompt\":\"What will you be doing after graduation\",\"type\":\"Radio\"}]}]\n";

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setTitle(getResources().getString(R.string.title_activity_survey_list));
        }

        Type token = new TypeToken<List<Survey>>() {}.getType();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(SurveyItem.class, new SurveyItemDeserializer());
        Gson gson = gsonBuilder.create();
        List<Survey> fromCustomGson = gson.fromJson(appString, token);

        surveyListRecycler.setLayoutManager(new LinearLayoutManager(this));
        surveyListRecycler.setAdapter(new SurveyListAdapter(this, fromCustomGson));
    }
}
