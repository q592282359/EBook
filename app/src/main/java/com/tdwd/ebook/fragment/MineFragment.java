package com.tdwd.ebook.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tdwd.ebook.R;
import com.tdwd.ebook.base.BaseFragment;
import com.tdwd.ebook.util.BmobFileUtils;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;

/**
 * @author :Leew
 * @date ：2018/9/30 on 10:56
 * Description:
 */
public class MineFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.mine_head)
    ImageView mMineHead;
    @BindView(R.id.mine_name)
    TextView mMineName;
    @BindView(R.id.Re_butt1)
    RelativeLayout mReButt1;
    @BindView(R.id.Re_butt2)
    RelativeLayout mReButt2;
    @BindView(R.id.Re_butt3)
    RelativeLayout mReButt3;
    @BindView(R.id.Re_butt4)
    RelativeLayout mReButt4;
    @BindView(R.id.Re_butt5)
    RelativeLayout mReButt5;
    @BindView(R.id.Re_butt6)
    RelativeLayout mReButt6;
    @BindView(R.id.Re_butt7)
    RelativeLayout mReButt7;
    @BindView(R.id.Re_butt8)
    RelativeLayout mReButt8;
    @BindView(R.id.Re_butt9)
    RelativeLayout mReButt9;

    public static MineFragment newInstance() {
        MineFragment fragment = new MineFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void InitViews() {
        mMineName.setText((String) BmobUser.getObjectByKey("nickname"));
        JSONObject jsonObject = (JSONObject) BmobUser.getObjectByKey("head");
        try {
            Glide.with(activity).load(jsonObject.getString("url")).into(mMineHead);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mReButt1.setOnClickListener(this);
        mReButt2.setOnClickListener(this);
        mReButt3.setOnClickListener(this);
        mReButt4.setOnClickListener(this);
        mReButt5.setOnClickListener(this);
        mReButt6.setOnClickListener(this);
        mReButt7.setOnClickListener(this);
        mReButt8.setOnClickListener(this);
        mReButt9.setOnClickListener(this);
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_mine;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Re_butt1:
                break;
            case R.id.Re_butt2:
                break;
            case R.id.Re_butt3:
                break;
            case R.id.Re_butt4:
                break;
            case R.id.Re_butt5:
                break;
            case R.id.Re_butt6:
                break;
            case R.id.Re_butt7:
                break;
            case R.id.Re_butt8:
                break;
            case R.id.Re_butt9:
                break;
        }
    }
}
