package com.coder4.easyufwandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.coder4.easyufwandroid.R;

import org.w3c.dom.Text;

/**
 * Created by lihy on 15/9/2.
 */
public class NavigationDrawerAdapter extends BaseAdapter {

    private Context context;
    private String[] titles;

    public NavigationDrawerAdapter(Context ctx){
        // init ctx and titles
        context = ctx;
        // init drawer menu text
        titles = context.getResources().getStringArray(R.array.drawer_menu_array);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public String getItem(int position) {
        if(position < titles.length){
            return titles[position];
        }else{
            return "";
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView view = (TextView)convertView;
        if(view == null){
            view = (TextView) LayoutInflater.from(context).inflate(R.layout.view_navigation_drawer_item, null);
        }
        view.setText(getItem(position));
        return view;
    }
}
