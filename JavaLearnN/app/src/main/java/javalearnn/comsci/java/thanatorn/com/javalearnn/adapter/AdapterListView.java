package javalearnn.comsci.java.thanatorn.com.javalearnn.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class AdapterListView extends BaseAdapter {

    private Context context;
    private List<?> lists;
    public int layout;

    public AdapterListView(Context context, List<?> lists) {
        this.context = context;
        this.lists = lists;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        //TextView lbTutorial;
        //TextView lbUpdateTutorial;
    }



    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder = null;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (view == null) {
            view = inflater.inflate(layout, null);

            holder = new ViewHolder();
            //holder.lbTutorial = (TextView) view.findViewById(R.id.lb_tutorial);
            //holder.lbUpdateTutorial = (TextView) view.findViewById(R.id.lb_updateTutorial);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        //Tutorial tutorial = (Tutorial)getItem(position);

        //holder.lbTutorial.setText(tutorial.getTutorialName());
        //holder.lbUpdateTutorial.setText(tutorial.getTutorialUpdateStr());
        return view;
    }




}
