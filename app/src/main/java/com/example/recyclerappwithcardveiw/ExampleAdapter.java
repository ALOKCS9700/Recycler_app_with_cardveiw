package com.example.recyclerappwithcardveiw;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

//6.2
    private ArrayList<exampleitem> mexamplelist;
//1
    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
    //4
        public static ImageView imageView;
        public static TextView textView;

//2
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);

            //4
            imageView=itemView.findViewById(R.id.imageView);
            textView=itemView.findViewById(R.id.textView);

        }
    }
//6.1
    public ExampleAdapter(ArrayList<exampleitem> examplelist) {
        mexamplelist=examplelist;

    }
//3
    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item,parent,false);
        ExampleViewHolder exampleViewHolder=new ExampleViewHolder(view);
        return  exampleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        //7
        exampleitem curretiteme=mexamplelist.get(position);
        ExampleViewHolder.imageView.setImageResource(curretiteme.getmImageresource());
        ExampleViewHolder.textView.setText(curretiteme.getmText());


    }

    @Override
    public int getItemCount() {
        return mexamplelist.size();
    }


}
