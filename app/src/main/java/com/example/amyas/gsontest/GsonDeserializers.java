package com.example.amyas.gsontest;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author: Amyas
 * date: 2017/12/6
 */

public class GsonDeserializers {
    static class DateDeserializer implements JsonDeserializer<Date> {
        @Override
        public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            assert json.isJsonPrimitive();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date parse = format.parse(json.getAsString());
                return parse;
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

}
