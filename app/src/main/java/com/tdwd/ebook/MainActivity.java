package com.tdwd.ebook;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.tdwd.ebook.base.BaseActivity;
import com.tdwd.ebook.fragment.FindFragment;
import com.tdwd.ebook.fragment.MainFragment;
import com.tdwd.ebook.fragment.MineFragment;
import com.tdwd.ebook.util.BottomNavigationViewHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.frame_layout)
    FrameLayout mFrameLayout;
    @BindView(R.id.bottom_navigation_view)
    BottomNavigationView mBottomNavigationView;

    private List<Fragment> fragments;
    private int lastIndex = 0;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        initFragment();
        selectFragment(0);
        initNavigation();
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(MainFragment.newInstance());
        fragments.add(FindFragment.newInstance());
        fragments.add(MineFragment.newInstance());
    }

    private void selectFragment(int position) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment currentFragment = fragments.get(position);
        Fragment lastFragment = fragments.get(lastIndex);
        lastIndex = position;
        ft.hide(lastFragment);
        if (!currentFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().remove(currentFragment).commit();
            ft.add(R.id.frame_layout, currentFragment);
        }
        ft.show(currentFragment);
        ft.commitAllowingStateLoss();
    }

    private void initNavigation() {
        BottomNavigationViewHelper.disableShiftMode(mBottomNavigationView);
        mBottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.tab_main:
                    selectFragment(0);
                    break;
                case R.id.tab_find:
                    selectFragment(1);
                    break;
                case R.id.tab_mine:
                    selectFragment(2);
                    break;
            }
            return true;
        });
    }
}
