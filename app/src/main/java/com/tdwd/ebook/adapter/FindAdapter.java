package com.tdwd.ebook.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tdwd.ebook.R;
import com.tdwd.ebook.bean.Find;
import com.tdwd.ebook.util.BmobFileUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author :Leew
 * @date ：2018/10/12 on 16:07
 * Description:
 */
public class FindAdapter extends RecyclerView.Adapter<FindAdapter.ViewHolder> {

    private List<Find> datas;
    private Context context;

    public FindAdapter(List<Find> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_find, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        BmobFileUtils.setimgonglide(context, datas.get(i).getUserhead(), viewHolder.mFindHead);

        BmobFileUtils.setimgonglide(context, datas.get(i).getImg1(), viewHolder.mFindImg1);
        BmobFileUtils.setimgonglide(context, datas.get(i).getImg2(), viewHolder.mFindImg2);
        BmobFileUtils.setimgonglide(context, datas.get(i).getImg3(), viewHolder.mFindImg3);
        viewHolder.mFindFrom.setText(datas.get(i).getFrom());
        viewHolder.mFindName.setText(datas.get(i).getUsername());
        viewHolder.mFindTime.setText(datas.get(i).getCreatedAt());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.find_head)
        ImageView mFindHead;
        @BindView(R.id.find_name)
        TextView mFindName;
        @BindView(R.id.find_img1)
        ImageView mFindImg1;
        @BindView(R.id.find_img2)
        ImageView mFindImg2;
        @BindView(R.id.find_img3)
        ImageView mFindImg3;
        @BindView(R.id.find_from)
        TextView mFindFrom;
        @BindView(R.id.find_time)
        TextView mFindTime;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
