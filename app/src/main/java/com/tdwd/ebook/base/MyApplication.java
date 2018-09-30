package com.tdwd.ebook.base;

import android.app.Application;
import android.util.Log;

import com.tdwd.ebook.bean.User;

import java.lang.invoke.MutableCallSite;

/**
 * @author :Leew
 * @date ：2018/9/30 on 9:27
 * Description:
 */
public class MyApplication extends Application {

public User mUser;

    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mUser = new User(this);
    }

    public static MyApplication getInstance(){
        return instance;
    }


}
