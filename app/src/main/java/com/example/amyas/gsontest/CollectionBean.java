package com.example.amyas.gsontest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * author: Amyas
 * date: 2017/12/6
 */

public class CollectionBean {
    //"type_id":10002
    // "pic":"/static_file/uploads/2/e1b888d6a41911e7a5f26c0b849ba396.png",
    // "news_id":10007,
    // "create_time":"2017-12-06 10:20:43",
    // "title":"秋季润肺吃什么？4款食谱保护肺部健康",
    // "type":"菜谱大全",
    // "id":28}
    private String title;
    private String pic;
    @SerializedName("news_id")
    private int newsId;
    private Date create_time;
    private String type;
    private int id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "CollectionBean{" +
                "title='" + title + '\'' +
                ", pic='" + pic + '\'' +
                ", newsId=" + newsId +
                ", create_time=" + create_time +
                ", type='" + type + '\'' +
                ", id=" + id +
                ", type_id=" + type_id +
                '}';
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    private int type_id;
}
