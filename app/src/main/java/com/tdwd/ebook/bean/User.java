package com.tdwd.ebook.bean;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author :Leew
 * @date ：2018/9/30 on 9:29
 * Description:
 */
public class User {
    private Application application;
    private SharedPreferences sharedPre;
    private SharedPreferences.Editor editor;

    public User(Application application) {
        this.application = application;
        sharedPre = application.getSharedPreferences("User", Context.MODE_PRIVATE);
        editor = sharedPre.edit();
    }

    public void setIsLogin(boolean isLogin) {
        editor.putBoolean("isLogin", isLogin);
        editor.commit();
    }
    public boolean isLogin() {
        return sharedPre.getBoolean("isLogin", false);
    }

    public void setUsername(String username) {
        editor.putString("username", username);
        editor.commit();
    }

    public String getUsername() {
        return sharedPre.getString("username", "");
    }

    public String getpassword() {
        return sharedPre.getString("password", "");

    }

    public void setpassword(String password) {
        editor.putString("password", password);
        editor.commit();
    }
}
