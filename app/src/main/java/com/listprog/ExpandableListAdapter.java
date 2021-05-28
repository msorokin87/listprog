//package com.listprog;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.content.Intent;
//import android.content.res.Resources;
//import android.graphics.Color;
//import android.graphics.Typeface;
//import android.graphics.drawable.GradientDrawable;
//import android.util.SparseBooleanArray;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.BaseExpandableListAdapter;
//import android.widget.CheckBox;
//import android.widget.ImageButton;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//import static com.listprog.R.color.colorButtonCreate;
//import static java.security.AccessController.getContext;
//
//public class ExpandableListAdapter extends BaseExpandableListAdapter {
//
//
//    private Context context;
//    private List<String> listDataHeader;
//    private HashMap<String, List<String>> listDataChild;
//
//
//
//
//    public ExpandableListAdapter(Context context, List<String> listDataHeader,
//                                 HashMap<String, List<String>> listChildData) {
//        this.context = context;
//        this.listDataHeader = listDataHeader;
//        this.listDataChild = listChildData;
//    }
//
//
//    @Override
//    public int getGroupCount() {
//        return this.listDataHeader.size();
//    }
//
//    @Override
//    public int getChildrenCount(int groupPosition) {
//        return this.listDataChild.get(this.listDataHeader.get(groupPosition)).size();
//    }
//
//    @Override
//    public Object getGroup(int groupPosition) {
//        return this.listDataHeader.get(groupPosition);
//    }
//
//    @Override
//    public Object getChild(int groupPosition, int childPosition) {
//        return this.listDataChild.get(this.listDataHeader.get(groupPosition)).get(childPosition);
//    }
//
//    @Override
//    public long getGroupId(int groupPosition) {
//        return groupPosition;
//    }
//
//    @Override
//    public long getChildId(int groupPosition, int childPosition) {
//
//        return childPosition;
//    }
//
//    @Override
//    public boolean hasStableIds() {
//        return true;
//    }
//
//    @Override
//    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
//        String headerTitle = (String) getGroup(groupPosition);
//        if (convertView == null) {
//            LayoutInflater infalInflater = (LayoutInflater) this.context
//                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = infalInflater.inflate(R.layout.list_group, null);
//        }
//
//        TextView lblListHeader = (TextView) convertView
//                .findViewById(R.id.listTitle);
//
//        lblListHeader.setTypeface(null, Typeface.BOLD);
//        lblListHeader.setText(headerTitle);
//
//        return convertView;
//    }
//
//    @Override
//    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
//        final String childText = (String) getChild(groupPosition, childPosition);
//
//        if (convertView == null) {
//            LayoutInflater infalInflater = (LayoutInflater) this.context
//                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = infalInflater.inflate(R.layout.list_item, null);
//        }
//
////        ImageButton check = convertView.findViewById(R.id.checkbox);
////
////          check.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                List <String> array = new ArrayList<String>();
////                //List <String> child = listDataChild.get(listDataHeader.get(groupPosition));
////                String selected = getChild(groupPosition, childPosition).toString();
////                Toast.makeText(context, selected, Toast.LENGTH_SHORT).show();
////                array.add(selected);
////                StringBuilder builder = new StringBuilder();
////                for (String s : array) {
////                    builder.append(s + "\n");
////                    listDataHeader.add(s);
////                                   }
////            }
////
////        });
//
//
//        TextView txtListChild = (TextView) convertView
//                .findViewById(R.id.expandedListItem);
//
//        txtListChild.setText(childText);
//        return convertView;
//    }
//
//    @Override
//    public boolean isChildSelectable(int groupPosition, int childPosition) {
//        return true;
//    }
//}
