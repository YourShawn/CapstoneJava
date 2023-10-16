package com.capstone.healthcare.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Constants {
    public static Gson GSON = new GsonBuilder().disableHtmlEscaping().setDateFormat("yyyy-MM-dd HH:mm:sss").create();
    public static Gson GSON_LINE = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().setDateFormat("yyyy-MM-dd HH:mm:sss").create();

    //查询排序字段
    public static String  ORDER_BY = "update_time desc";
    public static String  ORDER_BY_CREATE_TIME = "create_time desc";


}
