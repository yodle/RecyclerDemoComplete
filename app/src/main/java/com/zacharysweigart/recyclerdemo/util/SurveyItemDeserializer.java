package com.zacharysweigart.recyclerdemo.util;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.zacharysweigart.recyclerdemo.model.RadioSurveyItem;
import com.zacharysweigart.recyclerdemo.model.RatingSurveyItem;
import com.zacharysweigart.recyclerdemo.model.SurveyItem;
import com.zacharysweigart.recyclerdemo.model.TextSurveyItem;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SurveyItemDeserializer implements JsonDeserializer<SurveyItem> {
    @Override
    public SurveyItem deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        if(jsonObject.get("type").getAsString().toLowerCase().equals("text")) {
            return new TextSurveyItem(jsonObject.get("prompt").getAsString());
        } else if(jsonObject.get("type").getAsString().toLowerCase().equals("radio")) {
            RadioSurveyItem radioSurveyItem = new RadioSurveyItem(jsonObject.get("prompt").getAsString());
            List<String> options = new ArrayList<>();
            JsonArray jsonArray = jsonObject.get("options").getAsJsonArray();
            for(int i = 0; i < jsonArray.size(); i++) {
                options.add(jsonArray.get(0).getAsString());
            }
            radioSurveyItem.setOptions(options);
            return radioSurveyItem;
        } else if (jsonObject.get("type").getAsString().toLowerCase().equals("rating")) {
            RatingSurveyItem ratingSurveyItem = new RatingSurveyItem(jsonObject.get("prompt").getAsString());
            ratingSurveyItem.setNumStars(jsonObject.get("numStars").getAsInt());
            ratingSurveyItem.setStepSize(jsonObject.get("stepSize").getAsFloat());
            return ratingSurveyItem;
        } else {
            return new SurveyItem(jsonObject.get("prompt").getAsString(), jsonObject.get("type").getAsString());
        }
    }
}
