package com.tdwd.ebook.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.tdwd.ebook.R;
import com.tdwd.ebook.bean.MainAdapterBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author :Leew
 * @date ：2018/10/9 on 18:16
 * Description:
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {


    private List<MainAdapterBean> datas;
    private Context context;

    public MainAdapter(List<MainAdapterBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_main_recyclerview, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        if (datas.get(i).isIschecked()) {
            viewHolder.mMainShowLl.setVisibility(View.VISIBLE);
        } else {
            viewHolder.mMainShowLl.setVisibility(View.GONE);
        }
        viewHolder.mMainLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(viewHolder.itemView, viewHolder.getLayoutPosition());
            }
        });
        viewHolder.mMainTvJie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "借书成功!", Toast.LENGTH_SHORT).show();
                datas.remove(i);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.main_show_ll)
        LinearLayout mMainShowLl;
        @BindView(R.id.main_ll)
        LinearLayout mMainLl;
        @BindView(R.id.main_tv_jie)
        TextView mMainTvJie;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
