package com.tdwd.ebook.bean;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.tdwd.ebook.util.BmobFileUtils;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;

/**
 * @author :Leew
 * @date ：2018/9/30 on 9:29
 * Description:
 */
public class User extends BmobUser {

    private int sex;

    private String nickname;

    private String age;

    private BmobFile head;

    public BmobFile getHead() {
        return head;
    }

    public void setHead(BmobFile head) {
        this.head = head;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

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
