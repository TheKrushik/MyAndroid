package com.example.myandroid3.lec5;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myandroid3.R;

import static com.example.myandroid3.lec5.DetailActivity.EXTRA_KEY_POSITION;

public class MasterFragment extends Fragment implements View.OnClickListener {

    interface IMainFragment{
        void onItemClick(int position);
    }

    public static MasterFragment newInstance() {
        
        Bundle args = new Bundle();
        
        MasterFragment fragment = new MasterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public MasterFragment() {

    }

    RecyclerView recyclerView;
    Button button;
    IMainFragment listener;

    MasterFragment setListener(IMainFragment listener){
        this.listener = listener;
        return this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_master, container, false);
        recyclerView = view.findViewById(R.id.list);
        MasterFragment.MyAdapter adapter = new MasterFragment.MyAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddCardActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {
        int itemPosition = (int) v.getTag();
        if (null != listener) {
            listener.onItemClick(itemPosition);
        }

    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView text1, text2;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                text1 = itemView.findViewById(android.R.id.text1);
                text2 = itemView.findViewById(android.R.id.text2);
            }

            void bind(BankCardModel bankCard, int position) {
                text2.setText(bankCard.getOwnerName());
                text1.setText(bankCard.getNum());
                itemView.setTag(position);
                itemView.setOnClickListener(MasterFragment.this);
            }
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
            return new MyAdapter.ViewHolder(v);

        }

        @Override
        public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
            holder.bind(BankCardManager.getCard(position), position);
        }

        @Override
        public int getItemCount() {
            return BankCardManager.getCountCard();
        }
    }

}
