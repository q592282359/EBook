package com.tdwd.ebook.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.tdwd.ebook.R;
import com.tdwd.ebook.bean.Book;
import com.tdwd.ebook.util.BmobFileUtils;
import com.tdwd.ebook.util.ToastUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.DownloadFileListener;

/**
 * @author :Leew
 * @date ：2018/10/9 on 18:16
 * Description:
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {


    private List<Book> datas;
    private Context context;

    public MainAdapter(List<Book> datas, Context context) {
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
        viewHolder.mMainLl.setOnClickListener(v -> onItemClickListener.onItemClick(viewHolder.itemView, viewHolder.getLayoutPosition()));
        viewHolder.mBookZu.setOnClickListener(v -> {
            Toast.makeText(context, "借书成功!", Toast.LENGTH_SHORT).show();
            datas.remove(i);
           notifyDataSetChanged();
        });
        viewHolder.mBookName.setText(datas.get(i).getName());
        viewHolder.mBookAuthor.setText(String.format("作者: %s", datas.get(i).getAuthor()));
        viewHolder.mBookMoney.setText(String.format("%s书币", datas.get(i).getMoney()));
        viewHolder.mBookFromuser.setText(String.format("上传者: %s", datas.get(i).getFromusername()));
        viewHolder.mBookTime.setText(datas.get(i).getCreatedAt());
        BmobFileUtils.setimgonglide(context,datas.get(i).getImgpic(),viewHolder.mBookPic);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.book_pic)
        ImageView mBookPic;
        @BindView(R.id.book_name)
        TextView mBookName;
        @BindView(R.id.book_author)
        TextView mBookAuthor;
        @BindView(R.id.book_status)
        TextView mBookStatus;
        @BindView(R.id.main_ll)
        RelativeLayout mMainLl;
        @BindView(R.id.book_money)
        TextView mBookMoney;
        @BindView(R.id.book_fromuser)
        TextView mBookFromuser;
        @BindView(R.id.main_show_ll)
        LinearLayout mMainShowLl;
        @BindView(R.id.book_time)
        TextView mBookTime;
        @BindView(R.id.book_zu)
        TextView mBookZu;

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
