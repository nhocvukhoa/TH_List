package com.example.list1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context context;
    LinearLayout ln;
    ArrayList<ProfileModel> profileData;
    LayoutInflater layoutInflater;
    ProfileModel profileModel;

    public CustomAdapter(Context context,ArrayList<ProfileModel> profileData){
        this.context=context;
        this.profileData=profileData;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return profileData.size();
    }

    @Override
    public Object getItem(int i) {
        return profileData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return profileData.get(i).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View rowView = view;
        if (rowView==null) {
            rowView = layoutInflater.inflate(R.layout.list_row, null, true);
        }
        //link views
        ImageView avata1 = rowView.findViewById(R.id.avata1);
        TextView name= rowView.findViewById(R.id.name);
        TextView time = rowView.findViewById(R.id.time);
        ImageView avata2 = rowView.findViewById(R.id.avata2);


        profileModel= profileData.get(position);

        avata1.setImageResource(profileModel.getAvata());
        name.setText(profileModel.getName());
        time.setText(profileModel.getTime());
        avata2.setImageResource(profileModel.getAvata2());

        return rowView;
    }
    public void RemoveItem(int position){
        profileData.remove(position);
        notifyDataSetChanged();
    }


}
