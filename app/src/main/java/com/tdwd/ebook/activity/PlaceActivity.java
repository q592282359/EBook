package com.tdwd.ebook.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.tdwd.ebook.R;
import com.tdwd.ebook.adapter.HotCityAdapter;
import com.tdwd.ebook.adapter.PlaceAdapter;
import com.tdwd.ebook.base.BaseActivity;
import com.tdwd.ebook.bean.PlaceBean;
import com.tdwd.ebook.fragment.MainFragment;
import com.tdwd.ebook.util.StringUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author :Leew
 * @date ：2018/10/9 on 18:35
 * Description:
 */
public class PlaceActivity extends BaseActivity {
    @BindView(R.id.img_back)
    ImageView mImgBack;
    @BindView(R.id.tv_search)
    TextView mTvSearch;
    @BindView(R.id.now_city)
    TextView mNowCity;
    @BindView(R.id.hot_city)
    GridView mHotCity;
    @BindView(R.id.expandlistview)
    ExpandableListView mExpandlistview;

    private List<String> hotdatas = new ArrayList<>();
    private HotCityAdapter adapter;
    private List<PlaceBean> placedatas = new ArrayList<>();
    private PlaceAdapter placeAdapter;
    private String city;

    @Override
    public int getContentViewId() {
        return R.layout.activity_place;
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, PlaceActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initViews() {
        mImgBack.setOnClickListener(v -> finish());
        hotdatas = StringUtils.getHotCity();
        adapter = new HotCityAdapter(hotdatas, context);
        mHotCity.setAdapter(adapter);
        mHotCity.setOnItemClickListener((parent, view, position, id) -> {
            city = hotdatas.get(position);
            mNowCity.setText(city);
            MainFragment.PlaceToEvent event = new MainFragment.PlaceToEvent(city);
            event.setType("placerefresh");
            EventBus.getDefault().post(event);
            finish();
        });
        placedatas = StringUtils.getPlace();
        placeAdapter = new PlaceAdapter(placedatas, context);
        mExpandlistview.setGroupIndicator(null);
        mExpandlistview.setAdapter(placeAdapter);
        int count = mExpandlistview.getCount();
        for (int i = 0; i < count; i++) {
            mExpandlistview.expandGroup(i);
        }
        mExpandlistview.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            city = placedatas.get(groupPosition).getCityList().get(childPosition);
            mNowCity.setText(city);
            MainFragment.PlaceToEvent event = new MainFragment.PlaceToEvent(city);
            event.setType("placerefresh");
            EventBus.getDefault().post(event);
            finish();
            return true;
        });
    }
}
