package com.tdwd.ebook.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.tdwd.ebook.R;
import com.tdwd.ebook.activity.PlaceActivity;
import com.tdwd.ebook.adapter.MainAdapter;
import com.tdwd.ebook.base.BaseFragment;
import com.tdwd.ebook.bean.Book;
import com.tdwd.ebook.bean.Find;
import com.tdwd.ebook.util.GlideImageLoader;
import com.tdwd.ebook.util.ToastUtils;
import com.youth.banner.Banner;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

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
    @BindView(R.id.smartrefresh)
    SmartRefreshLayout mSmartrefresh;
    private List<Integer> images = new ArrayList<>();
    private MainAdapter adapter;
    private List<Book> datas = new ArrayList<>();

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void InitViews() {
        EventBus.getDefault().register(this);
        getdatas("北京");
        initbanners();
        setlisteners();
    }

    private void setlisteners() {
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
        mSmartrefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                getdatas(mTvPlace.getText().toString());
                mSmartrefresh.finishRefresh();
            }
        });
    }

    private void initbanners() {
        mBanner.setImageLoader(new GlideImageLoader());
        images.add(R.mipmap.banner1);
        images.add(R.mipmap.banner2);
        images.add(R.mipmap.banner3);
        mBanner.setImages(images);
        mBanner.start();
    }

    private void getdatas(String city) {
        BmobQuery<Book> query = new BmobQuery<>();
        query.addWhereEqualTo("place", city);
        query.findObjects(new FindListener<Book>() {
            @Override
            public void done(List<Book> list, BmobException e) {
                if (e == null) {
                    datas = list;
                    adapter = new MainAdapter(datas, context);
                    adapter.setOnItemClickListener((view, position) -> {
                        for (int i = 0; i < datas.size(); i++) {
                            if (i == position) {
                                if (datas.get(position).isIschecked()) {
                                    datas.get(position).setIschecked(false);
                                } else {
                                    datas.get(position).setIschecked(true);
                                }
                            } else {
                                datas.get(i).setIschecked(false);
                            }
                        }
                        adapter.notifyDataSetChanged();
                    });
                    mRecyclerview.setLayoutManager(new LinearLayoutManager(context));
                    mRecyclerview.setAdapter(adapter);
                }
            }
        });
    }


    @Override
    public int getLayoutResID() {
        return R.layout.fragment_main;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getMsg(PlaceToEvent event) {
        if (event.getType().equals("placerefresh")) {
            mTvPlace.setText(event.getCity());
            getdatas(event.getCity());
        }
    }
    public static class PlaceToEvent {
        private String city;
        private String type;

        public PlaceToEvent(String city) {
            this.city = city;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
