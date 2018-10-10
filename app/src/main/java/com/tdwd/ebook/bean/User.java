package com.tdwd.ebook.bean;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import cn.bmob.v3.BmobUser;

/**
 * @author :Leew
 * @date ：2018/9/30 on 9:29
 * Description:
 */
public class User extends BmobUser {

    private int sex;

    private String age;

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
