package com.example.myandroid.base;

import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.myandroid.lec5.BankCardModel;

public class MyAdapter extends BaseAdapter<BankCardModel, IMyListener<BankCardModel>, MyViewHolder> {

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(inflate(android.R.layout.simple_list_item_2, parent));
    }
}
