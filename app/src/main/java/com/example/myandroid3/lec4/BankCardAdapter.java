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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bank_card, parent, false);
        return new BankCardViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull BankCardViewHolder holder, int position) {
        BankCard bankCard = bankCardList.get(position);

        holder.txtOwnerName.setText(bankCard.getOwnerName());
        holder.txtCardNumber.setText(bankCard.getNum());
        holder.txtDate.setText(bankCard.getDate());
        holder.txtBalance.setText(String.valueOf(bankCard.getAmount()));
    }

    @Override
    public int getItemCount() {
        return bankCardList.size();
    }

    public class BankCardViewHolder extends RecyclerView.ViewHolder {

        TextView txtOwnerName;
        TextView txtCardNumber;
        TextView txtDate;
        TextView txtBalance;

        public BankCardViewHolder(@NonNull View itemView) {
            super(itemView);

            txtOwnerName = itemView.findViewById(R.id.txtOwnerName);
            txtCardNumber = itemView.findViewById(R.id.txtCardNumber);
            txtDate = itemView.findViewById(R.id.txtDate);
            txtBalance = itemView.findViewById(R.id.txtBalance);

        }
    }
}
