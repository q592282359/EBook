package com.tdwd.ebook.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.tdwd.ebook.R;
import com.tdwd.ebook.activity.PlaceActivity;
import com.tdwd.ebook.adapter.MainAdapter;
import com.tdwd.ebook.base.BaseFragment;
import com.tdwd.ebook.bean.MainAdapterBean;
import com.tdwd.ebook.util.GlideImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author :Leew
 * @date ：2018/9/30 on 10:56
 * Description:
 */
public class MainFragment extends BaseFragment {

    @BindView(R.id.tv_place)
    TextView mTvPlace;
    @BindView(R.id.tv_search)
    TextView mTvSearch;
    @BindView(R.id.img_plus)
    ImageView mImgPlus;
    @BindView(R.id.banner)
    Banner mBanner;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    private List<Integer> images = new ArrayList<>();
    private MainAdapter adapter;
    private List<MainAdapterBean> datas = new ArrayList<>();

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void InitViews() {
        for (int i = 0; i < 10; i++) {
            datas.add(new MainAdapterBean("" + i));
        }
        adapter = new MainAdapter(datas, context);
        adapter.setOnItemClickListener(new MainAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                for (int i = 0; i < datas.size(); i++) {
                    if (i == position) {
                        if(datas.get(position).isIschecked()){
                            datas.get(position).setIschecked(false);
                        }else {
                            datas.get(position).setIschecked(true);
                        }
                    } else {
                        datas.get(i).setIschecked(false);
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });
        mRecyclerview.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerview.setAdapter(adapter);
        mBanner.setImageLoader(new GlideImageLoader());
        images.add(R.mipmap.banner1);
        images.add(R.mipmap.banner2);
        images.add(R.mipmap.banner3);
        mBanner.setImages(images);
        mBanner.start();
        mTvPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlaceActivity.start(activity);
            }
        });
        mTvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mImgPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }



    @Override
    public int getLayoutResID() {
        return R.layout.fragment_main;
    }

}
