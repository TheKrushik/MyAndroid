//package com.example.myandroid3.lec5;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.myandroid3.R;
//
//import java.util.List;
//
//public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
////        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bank_card, parent, false);
//        View v = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
//        return new ViewHolder(v);
//
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        BankCardModel bankCard = BankCardManager.getCard(position);
//        holder.bind(bankCard);
//    }
//
//    @Override
//    public int getItemCount() {
//        return BankCardManager.getCountCard();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//
//        //        TextView txtOwnerName, txtCardNumber, txtDate, txtBalance;
//        TextView text1, text2;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//
////            txtOwnerName = itemView.findViewById(R.id.txtOwnerName);
////            txtCardNumber = itemView.findViewById(R.id.txtCardNumber);
////            txtDate = itemView.findViewById(R.id.txtDate);
////            txtBalance = itemView.findViewById(R.id.txtBalance);
//
//            text1 = itemView.findViewById(android.R.id.text1);
//            text2 = itemView.findViewById(android.R.id.text2);
//
//        }
//
//        void bind(BankCardModel bankCard) {
////            txtOwnerName.setText(bankCard.getOwnerName());
////            txtCardNumber.setText(bankCard.getNum());
////            txtDate.setText(bankCard.getDate());
////            txtBalance.setText(String.valueOf(bankCard.getAmount()));
//
//            text2.setText(bankCard.getOwnerName());
//            text1.setText(bankCard.getNum());
//            itemView.setTag(bankCard);
//        }
//    }
//}
