package com.example.myandroid.lec5;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myandroid.R;

public class MasterFragment extends Fragment implements MyAdapter.IMyAdapter {

    interface IMainFragment{
        void onItemClick(int position);
    }

    public static MasterFragment newInstance() {
        Bundle args = new Bundle();
        MasterFragment fragment = new MasterFragment();
        fragment.setArguments(args);
        return fragment;
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
        MyAdapter adapter = new MyAdapter();
        adapter.setOnItemClickListener(this);

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
    public void onItemClick(int position) {
        if (null != listener) {
            listener.onItemClick(position);
        }
    }

}
