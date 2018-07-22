package com.example.qaite.pressnguess;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class InstrumentAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Integer> ids;
    private ArrayList<String> names;
    public InstrumentAdapter(Context context, ArrayList<Integer> ids, ArrayList<String> names){
        this.context = context;
        this.ids = ids;
        this.names = names;
    }
    @Override
    public int getCount(){
        return names.size();
    }
    @Override
    public Object getItem(int position){
        return names.get(position);
    }
    @Override
    public long getItemId(int position){
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if (convertView == null){
            convertView = View.inflate(context, R.layout.row, null);
        }
        ImageView ivInstrument = convertView.findViewById(R.id.ivInstrument);
        TextView tvInstrument = convertView.findViewById(R.id.tvInstrument);
        ivInstrument.setImageResource(ids.get(position));
        tvInstrument.setText(names.get(position));
        return convertView;
    }
}
