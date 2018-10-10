package com.tdwd.ebook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tdwd.ebook.R;

import java.util.List;

/**
 * @author :Leew
 * @date ：2018/10/9 on 18:49
 * Description:
 */
public class HotCityAdapter extends BaseAdapter {
    private List<String> datas;
    private Context context;

    public HotCityAdapter(List<String> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView text = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_hot_city, parent, false);
            text = convertView.findViewById(R.id.hot_city_text);
            convertView.setTag(text);
        } else {
            text = (TextView) convertView.getTag();
        }
        text.setText(datas.get(position));
        return convertView;
    }
}
