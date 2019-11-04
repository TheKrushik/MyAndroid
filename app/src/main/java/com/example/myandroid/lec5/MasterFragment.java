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
import com.example.myandroid.base.IMyListener;
import com.example.myandroid.base.MyAdapter;

import java.util.List;

public class MasterFragment extends Fragment implements IMyListener {

    interface IMainFragment {
        void onItemClick(int position);
    }

    public static MasterFragment newInstance() {
        Bundle args = new Bundle();
        MasterFragment fragment = new MasterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private RecyclerView recyclerView;
    private Button button;
    private IMainFragment listener;

    MasterFragment setListener(IMainFragment listener) {
        this.listener = listener;
        return this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_master, container, false);

        setupRecycler(view);
        setupAddButton(view);

        return view;
    }

    private void setupRecycler(View view) {
        recyclerView = view.findViewById(R.id.list);

        MyAdapter adapter = new MyAdapter();
        adapter.setListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<BankCardModel> cards = BankCardManager.getBankCards();
        adapter.setItems(cards);
    }

    private void setupAddButton(View view) {
        button = view.findViewById(R.id.button);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), AddCardActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onItemClicked(int position) {
        if (null != listener) {
            listener.onItemClick(position);
        }
    }
}
