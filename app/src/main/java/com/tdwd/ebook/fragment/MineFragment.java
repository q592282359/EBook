package com.tdwd.ebook.fragment;

import android.os.Bundle;

import com.tdwd.ebook.R;
import com.tdwd.ebook.base.BaseFragment;

/**
 * @author :Leew
 * @date ：2018/9/30 on 10:56
 * Description:
 */
public class MineFragment extends BaseFragment{
    
    public static MineFragment newInstance() {
        MineFragment fragment = new MineFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    protected void InitViews() {
        
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_mine;
    }
}
