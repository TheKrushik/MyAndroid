package com.example.myandroid3.lec4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myandroid3.R;

import java.util.List;

public class BankCardAdapter extends RecyclerView.Adapter<BankCardAdapter.BankCardViewHolder> {

    private List<BankCard> bankCardList;

    public BankCardAdapter(List<BankCard> list) {
        this.bankCardList = list;
    }

    @NonNull
    @Override
    public BankCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bank_card, parent, false);
        View v = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
        return new BankCardViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull BankCardViewHolder holder, int position) {
        BankCard bankCard = bankCardList.get(position);

        holder.text1.setText(bankCard.getOwnerName());
        holder.text2.setText(bankCard.getNum());
    }

    @Override
    public int getItemCount() {
        return bankCardList.size();
    }

    public class BankCardViewHolder extends RecyclerView.ViewHolder {

        TextView text1;
        TextView text2;

        public BankCardViewHolder(@NonNull View itemView) {
            super(itemView);

//            textCard = itemView.findViewById(R.id.text_card);
            text1 = itemView.findViewById(android.R.id.text1);
            text2 = itemView.findViewById(android.R.id.text2);
        }
    }
}
