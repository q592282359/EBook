package com.tdwd.ebook.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.tdwd.ebook.R;
import com.tdwd.ebook.adapter.FindAdapter;
import com.tdwd.ebook.base.BaseFragment;
import com.tdwd.ebook.bean.Find;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * @author :Leew
 * @date ：2018/9/30 on 10:56
 * Description:
 */
public class FindFragment extends BaseFragment {

    @BindView(R.id.find_recyclerview)
    RecyclerView mFindRecyclerview;
    @BindView(R.id.find_refresh)
    SmartRefreshLayout mFindRefresh;

    private FindAdapter adapter;
    private List<Find> datas;

    public static FindFragment newInstance() {
        FindFragment fragment = new FindFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void InitViews() {
        getdatas();
    }

    private void getdatas() {
        datas = new ArrayList<>();
        BmobQuery<Find> query = new BmobQuery<>();
        query.findObjects(new FindListener<Find>() {
            @Override
            public void done(List<Find> list, BmobException e) {
                datas = list;
                adapter = new FindAdapter(datas, activity);
                mFindRecyclerview.setLayoutManager(new LinearLayoutManager(activity));
                mFindRecyclerview.setAdapter(adapter);
            }
        });
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_find;
    }

}
