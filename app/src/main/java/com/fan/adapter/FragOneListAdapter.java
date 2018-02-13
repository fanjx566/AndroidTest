package com.fan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import app.fan.com.myapp.R;

public class FragOneListAdapter extends BaseAdapter {

    public ListView mListView;
    public Context mContext;
    public List<String> mList;

    static class ViewHolder {
        TextView content;

        ViewHolder() {
        }
    }
    public  FragOneListAdapter(Context context,List list) {
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewholder;
        if (convertView == null) {
            viewholder = new ViewHolder();
            convertView = LayoutInflater.from(this.mContext).inflate(R.layout.content_main, null);
            viewholder.content = (TextView) convertView.findViewById(R.id.tv_maincontent);
            convertView.setTag(viewholder);
        }
        viewholder = (ViewHolder) convertView.getTag();
        viewholder.content.setText("........."+position);
        // view.setBackgroundResource(colors[position % 2]);
        // view.getBackground().setAlpha(150);
        return convertView;
    }


}
