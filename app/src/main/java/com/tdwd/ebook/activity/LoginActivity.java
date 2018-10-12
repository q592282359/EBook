package com.tdwd.ebook.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tdwd.ebook.MainActivity;
import com.tdwd.ebook.R;
import com.tdwd.ebook.base.BaseActivity;
import com.tdwd.ebook.bean.User;
import com.xw.repo.XEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * @author :Leew
 * @date ：2018/9/30 on 9:26
 * Description:
 */
public class LoginActivity extends BaseActivity {


    @BindView(R.id.et_username)
    XEditText mEtUsername;
    @BindView(R.id.et_passWord)
    XEditText mEtPassWord;
    @BindView(R.id.btn_register)
    TextView mBtnRegister;
    @BindView(R.id.btn_login)
    TextView mBtnLogin;
    @BindView(R.id.btn_forget_password)
    TextView mBtnForgetPassword;
    @BindView(R.id.ll)
    LinearLayout mLl;

    @Override
    public int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initViews() {
        mBtnRegister.setOnClickListener(v -> {
        });
        mBtnLogin.setOnClickListener(v -> {
            BmobUser.loginByAccount(mEtUsername.getText().toString(), mEtPassWord.getText().toString(), new LogInListener<User>() {
                @Override
                public void done(User user, BmobException e) {
                    if (e == null) {
                        SharedPreferences sp = getSharedPreferences("login", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putBoolean("islogin", true);
                        editor.putString("username",mEtUsername.getText().toString());
                        editor.putString("password",mEtPassWord.getText().toString());
                        editor.commit();
                        startActivity(new Intent(context, MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                        Log.e("liwei", "done: " + e.toString());
                    }
                }
            });
        });
    }


}
