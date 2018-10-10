package com.tdwd.ebook.activity;

import android.content.Intent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;

import com.tdwd.ebook.MainActivity;
import com.tdwd.ebook.R;
import com.tdwd.ebook.base.BaseActivity;
import com.tdwd.ebook.base.MyApplication;

/**
 * @author :Leew
 * @date ：2018/9/30 on 9:18
 * Description:
 */
public class SplashAactivity extends BaseActivity {

    private AlphaAnimation alphaAnimation;
    private LinearLayout layout;

    @Override
    public int getContentViewId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initViews() {
        layout = findViewById(R.id.layout_splash);
        alphaAnimation = new AlphaAnimation(1.0f, 1.0f);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (getSharedPreferences("login",MODE_PRIVATE).getBoolean("islogin",false)) {
                    startActivity(new Intent(context, MainActivity.class));
                } else {
                    startActivity(new Intent(context, LoginActivity.class));
                }
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        layout.setAnimation(alphaAnimation);
    }
}
