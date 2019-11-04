package com.example.myandroid.lec5;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private static final String TAG = "MyAdapter";

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView text1, text2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(android.R.id.text1);
            text2 = itemView.findViewById(android.R.id.text2);
        }

        void bind(BankCardModel bankCard) {
            text2.setText(bankCard.getOwnerName());
            text1.setText(bankCard.getNum());

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(position);
                    Log.d(TAG, "onClick: " + position);
                }
            }
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
        return new MyAdapter.ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, final int position) {
        BankCardModel card = BankCardManager.getCard(position);
        holder.bind(card);
    }

    @Override
    public int getItemCount() {
        return BankCardManager.getCountCard();
    }

    private IMyAdapter listener;

    public interface IMyAdapter {
        void onItemClick(int position);
    }

    void setOnItemClickListener(IMyAdapter listener) {
        this.listener = listener;
    }

}
