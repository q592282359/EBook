package com.tdwd.ebook.base;

import android.app.Application;


import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;

/**
 * @author :Leew
 * @date ：2018/9/30 on 9:27
 * Description:
 */
public class MyApplication extends Application {

    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        Bmob.initialize(this,"8c8be1fdfb6918a6039120b8592df89d");
    }

    public static MyApplication getInstance(){
        return instance;
    }


}