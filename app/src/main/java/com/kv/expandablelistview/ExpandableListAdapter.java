package com.kv.expandablelistview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> expandableListTitle;
    //    private HashMap<String, List<String>> expandableListDetail;
    ArrayList<RetorentDetail.Menuitems> expandableListDetail;

    public ExpandableListAdapter(Context context, List<String> expandableListTitle, ArrayList<RetorentDetail.Menuitems> expandableListDetail) {
        this.context = context;
        this.expandableListTitle = expandableListTitle;
        this.expandableListDetail = expandableListDetail;
    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        return this.expandableListDetail.get(listPosition).getMenuitems().get(expandedListPosition);
    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    @Override
    public View getChildView(int listPosition, final int expandedListPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        RetorentDetail.Menuitems1 item = (RetorentDetail.Menuitems1) getChild(listPosition, expandedListPosition);

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item, null);
        }

        TextView tv_name = convertView.findViewById(R.id.tv_name);
        TextView tv_price = convertView.findViewById(R.id.tv_price);
        TextView tv_extra = convertView.findViewById(R.id.tv_extra);

        tv_name.setText(item.getName());
        tv_price.setText(item.getPrice() + "");
        tv_extra.setText(item.getDescription());

        return convertView;
    }

    @Override
    public int getChildrenCount(int listPosition) {
        return this.expandableListDetail.get(listPosition).getMenuitems().size();
    }

    @Override
    public Object getGroup(int listPosition) {
        return this.expandableListTitle.get(listPosition);
    }

    @Override
    public int getGroupCount() {
        return this.expandableListTitle.size();
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @TargetApi(Build.VERSION_CODES.M)
    @androidx.annotation.RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View getGroupView(int listPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String listTitle = (String) getGroup(listPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_group, null);
        }
        TextView listTitleTextView = convertView.findViewById(R.id.listTitle);
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);

        ImageView img = convertView.findViewById(R.id.img);
        if (isExpanded) {
            img.setImageResource(R.drawable.ic_keyboard_arrow_up);
        } else {
            img.setImageResource(R.drawable.ic_keyboard_arrow_down);
        }
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }
}
