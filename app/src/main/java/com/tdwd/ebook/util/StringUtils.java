package com.tdwd.ebook.util;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tdwd.ebook.base.MyApplication;
import com.tdwd.ebook.bean.PlaceBean;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :Leew
 * @date ：2018/10/9 on 18:54
 * Description:
 */
public class StringUtils {

    public static List<String> getHotCity() {
        List<String> hotcitys = new ArrayList<>();
        hotcitys.add("北京");
        hotcitys.add("上海");
        hotcitys.add("广州");
        hotcitys.add("深圳");
        hotcitys.add("重庆");
        return hotcitys;
    }

    public static List<PlaceBean> getPlace() {
        String citys = null;
        try {
            InputStream is = MyApplication.getInstance().getAssets().open("citys.txt");
            int length = is.available();
            byte[] buffer = new byte[length];
            is.read(buffer);
            citys = new String(buffer,"GBK");
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject obj = JSON.parseObject(citys);
        JSONArray array = obj.getJSONArray("list");
        List<PlaceBean> placeBeans = array.toJavaList(PlaceBean.class);
        return placeBeans;
    }
}
