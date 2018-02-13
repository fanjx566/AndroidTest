package com.fan.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.fan.adapter.FragOneListAdapter;
import com.fan.custom.MyListView;

import java.util.ArrayList;
import java.util.List;

import app.fan.com.myapp.R;

public class MainFragmentOne extends Fragment {
    ViewGroup parent;
    List<String> lt_content = new ArrayList<String>();
    Context mContext;
    public  void MainFragmentOne(Context context,ViewGroup parent){
        mContext = context;
        this.parent = parent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragmentone, null);
        MyListView mListView = (MyListView) rootView.findViewById( R.id.lv_fragmentone);
        mListView.setNestedpParent(parent);
        for(int i = 0;i<20;i++){
            lt_content.add("this is what..."+i);
        }
        ListAdapter adapter = new FragOneListAdapter(mContext,lt_content);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext,"haha"+position,Toast.LENGTH_LONG).show();
            }
        });

        return rootView;
    }

}
