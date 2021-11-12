package com.example.randomapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyHolder extends RecyclerView.ViewHolder {
    ImageView profImg , postImg;
    TextView mTitle;
    public MyHolder(@NonNull View itemView) {
        super(itemView);
        this.postImg = itemView.findViewById(R.id.Post);
        this.profImg = itemView.findViewById(R.id.imgV);
        this.mTitle = itemView.findViewById(R.id.textV);
    }
}
