package com.tdwd.ebook.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.tdwd.ebook.MainActivity;
import com.tdwd.ebook.R;
import com.tdwd.ebook.base.BaseActivity;
import com.xw.repo.XEditText;

/**
 * @author :Leew
 * @date ：2018/9/30 on 9:26
 * Description:
 */
public class LoginActivity extends BaseActivity {
    private TextView login;
    private XEditText username;
    private XEditText password;


    @Override
    public int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initViews() {
        login = findViewById(R.id.btn_login);
        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_passWord);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, MainActivity.class));
                finish();
            }
        });
    }
}
