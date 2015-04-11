package com.zacharysweigart.recyclerdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.zacharysweigart.recyclerdemo.R;
import com.zacharysweigart.recyclerdemo.adapter.SurveyAdapter;
import com.zacharysweigart.recyclerdemo.adapter.SurveyListAdapter;
import com.zacharysweigart.recyclerdemo.model.Survey;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SurveyActivity extends ActionBarActivity {
    public static final String SURVEY = "survey";

    private Survey survey;

    @InjectView(R.id.survey_recycler_view)
    RecyclerView surveyRecycler;

    public static Intent getIntent(Activity activity, Survey survey) {
        Intent intent = new Intent(activity, SurveyActivity.class);
        intent.putExtra(SURVEY, survey);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        ButterKnife.inject(this);

        Intent intent = getIntent();
        survey = (Survey) intent.getSerializableExtra(SURVEY);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(survey.getName());
        }

        surveyRecycler.setLayoutManager(new LinearLayoutManager(this));
        surveyRecycler.setAdapter(new SurveyAdapter(this, survey.getSurveyItems()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
