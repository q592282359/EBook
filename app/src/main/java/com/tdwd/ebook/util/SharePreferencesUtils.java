package com.tdwd.ebook.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.tdwd.ebook.base.MyApplication;

import static android.content.Context.MODE_PRIVATE;

/**
 * @author :Leew
 * @date ：2018/10/12 on 10:43
 * Description:
 */
public class SharePreferencesUtils {


    public static boolean getIsLogin(){
       return MyApplication.getInstance().getSharedPreferences("login", MODE_PRIVATE).getBoolean("islogin",false);
    }
    public static String getUserName(){
        return MyApplication.getInstance().getSharedPreferences("login", MODE_PRIVATE).getString("username","");
    }
    public static String getPassWord(){
        return MyApplication.getInstance().getSharedPreferences("login", MODE_PRIVATE).getString("password","");
    }
    public static void setIsLogin(boolean isLogin){
        SharedPreferences sp = MyApplication.getInstance().getSharedPreferences("login", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("islogin", isLogin);
        editor.apply();
    }
    public static void setUserName(String userName){
        SharedPreferences sp = MyApplication.getInstance().getSharedPreferences("login", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("username",userName);
        editor.apply();
    }
    public static void setPassWord(String passWord){
        SharedPreferences sp = MyApplication.getInstance().getSharedPreferences("login", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("password",passWord);
        editor.apply();
    }
}
