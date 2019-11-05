package com.example.myandroid.base;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myandroid.model.BankCardModel;

public class MyViewHolder extends BaseViewHolder<BankCardModel, IMyListener<BankCardModel>> {

    private TextView text1;
    private TextView text2;

    public MyViewHolder(View itemView) {
        super(itemView);
        text1 = itemView.findViewById(android.R.id.text1);
        text2 = itemView.findViewById(android.R.id.text2);
    }

    @Override
    public void onBind(BankCardModel item, @Nullable IMyListener<BankCardModel> listener) {

        text2.setText(item.getOwnerName());
        text1.setText(item.getNum());

        if (listener != null) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                itemView.setOnClickListener(v -> listener.onItemClicked(position));
            }
        }
    }
}
