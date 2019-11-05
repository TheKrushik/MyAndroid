package com.example.myandroid.lec5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myandroid.model.BaseModel;

import java.util.ArrayList;
import java.util.List;

public class MyBaseAdapter extends RecyclerView.Adapter<MyBaseAdapter.ViewHolder> {

    private List<BaseModel> list;

    public MyBaseAdapter() {
        list = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
        return new MyBaseAdapter.ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyBaseAdapter.ViewHolder holder, final int position) {
        BaseModel card = list.get(position);
        holder.bind(card);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setItems(List<BaseModel> items) {
        this.list.clear();
        this.list.addAll(items);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView text1, text2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(android.R.id.text1);
            text2 = itemView.findViewById(android.R.id.text2);
        }

        void bind(BaseModel item) {
            text1.setText(item.getText1());
            text2.setText(item.getText2());

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClicked(position);
                }
            }
        }
    }

    private IMyAdapter listener;

    public interface IMyAdapter {
        void onItemClicked(int position);
    }

    void setOnItemClickListener(IMyAdapter listener) {
        this.listener = listener;
    }

}
