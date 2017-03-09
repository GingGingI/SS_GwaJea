package com.example.a302.androiddbstudy2;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by 302 on 2017-03-09.
 */
public class mAdapter extends BaseAdapter {

    Context context;
    ArrayList<hooman> al;
    int layout;
    LayoutInflater inf;

    public mAdapter(Context context, ArrayList<hooman> al, int layout){
        this.context = context;
        this.al = al;
        this.layout = layout;
        inf= (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount(){
        return al.size();
    }

}
