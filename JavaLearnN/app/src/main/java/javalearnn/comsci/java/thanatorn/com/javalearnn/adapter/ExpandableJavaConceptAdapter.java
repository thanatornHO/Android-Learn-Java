package javalearnn.comsci.java.thanatorn.com.javalearnn.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import javalearnn.comsci.java.thanatorn.com.javalearnn.R;

public class ExpandableJavaConceptAdapter extends BaseExpandableListAdapter {

    private LayoutInflater inflater;
    private List<String> groupItem;
    private HashMap<String, List<String>> childItem;
    private Context context;

    public ExpandableJavaConceptAdapter(Context context, List<String> groupItem, HashMap<String, List<String>> childItem) {
        this.groupItem = groupItem;
        this.childItem = childItem;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return groupItem.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childItem.get(groupItem.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupItem.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childItem.get(groupItem.get(groupPosition)).get(childPosition);
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
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    // Returns view for the list group header
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup parent) {
        String title = (String) getGroup(groupPosition);
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.list_group, null);
        }

        TextView lbListHeader = (TextView) view.findViewById(R.id.lb_list_header);
        lbListHeader.setTypeface(null, Typeface.BOLD);
        lbListHeader.setText(title);

        return view;
    }

    // Returns view for list child item
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup parent) {
        final String childData = (String) getChild(groupPosition, childPosition);

        if (view == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = infalInflater.inflate(R.layout.list_child, null);
        }
        TextView lbListChild = (TextView) view.findViewById(R.id.lb_list_child);
        lbListChild.setText(childData);
        return view;
    }

}
