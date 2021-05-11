package com.example.jakathishab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SpinnerAdapter extends ArrayAdapter<SpinnerItem> {

    public SpinnerAdapter(Context context, ArrayList<SpinnerItem> spinnerList)
    {
        super(context,0,spinnerList);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView,ViewGroup parent)
    {
        if(convertView==null)
        {
            convertView= LayoutInflater.from((getContext())).inflate(R.layout.sample_view,parent,false);
        }
        /*TextView textView=(TextView) convertView.findViewById(R.id.textSpinner);
        TextView editText=(TextView) convertView.findViewById(R.id.inputSpinner);
        SpinnerItem spinnerItem=getItem(position);
        if(spinnerItem!=null)
        {
            textView.setText(spinnerItem.getTextValue());
            editText.setText(spinnerItem.getEditTextValue());
        }*/
        return convertView;
    }
}
