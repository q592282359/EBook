package com.tdwd.ebook.util;

import android.content.Context;
import android.support.annotation.StringRes;
import android.view.Gravity;
import android.widget.Toast;

import com.tdwd.ebook.base.MyApplication;

/**
 * @author :Leew
 * @date ：2018/10/12 on 11:15
 * Description:
 */
public class ToastUtils {
    private static Toast toast = MyApplication.getInstance().toast;
    private static Toast newtoast;

    public static void showToast(Context context, String content) {
        if (toast == null) {
            toast = Toast.makeText(context, content, Toast.LENGTH_SHORT);
        } else {
            toast.setText(content);
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();
    }

    public static void showToast(@StringRes int resId) {
        showToast(MyApplication.getInstance(), MyApplication.getInstance().getString(resId));
    }

    public static void showToast(String msg) {
        showToast(MyApplication.getInstance(), msg);
    }


}
