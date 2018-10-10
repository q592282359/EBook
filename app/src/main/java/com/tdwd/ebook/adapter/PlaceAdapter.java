package com.tdwd.ebook.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.tdwd.ebook.R;
import com.tdwd.ebook.bean.PlaceBean;

import java.util.List;

/**
 * @author :Leew
 * @date ：2018/10/10 on 10:05
 * Description:
 */
public class PlaceAdapter extends BaseExpandableListAdapter{

    private List<PlaceBean> datas;
    private Context context;

    public PlaceAdapter(List<PlaceBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return datas.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return datas.get(groupPosition).getCityList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return datas.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return datas.get(groupPosition).getCityList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        TextView text = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_place_group,parent,false);
            text = convertView.findViewById(R.id.group_text);
            convertView.setTag(text);
        }else{
            text = (TextView) convertView.getTag();
        }
        text.setText(datas.get(groupPosition).getCode());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        TextView text = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_place_child,parent,false);
            text = convertView.findViewById(R.id.child_text);
            convertView.setTag(text);
        }else{
            text = (TextView) convertView.getTag();
        }
        text.setText(datas.get(groupPosition).getCityList().get(childPosition));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
