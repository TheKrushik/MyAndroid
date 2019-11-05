package com.example.myandroid.lec5;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myandroid.R;
import com.example.myandroid.data.BankCardManager;
import com.example.myandroid.model.BankCardModel;

import java.util.Locale;


public class DetailCardFragment extends Fragment {
    public static final String EXTRA_KEY_POSITION = "extra_key_position";

    private TextView cardNumber, ownerName, expires, pin, balance;

    public static DetailCardFragment newInstance(int position) {

        Bundle args = new Bundle();
        args.putInt(EXTRA_KEY_POSITION, position);

        DetailCardFragment fragment = new DetailCardFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public DetailCardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_card, container, false);

        cardNumber = view.findViewById(R.id.cardNumber);
        ownerName = view.findViewById(R.id.ownerName);
        expires = view.findViewById(R.id.expires);
        pin = view.findViewById(R.id.pin);
        balance = view.findViewById(R.id.balance);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle arguments = getArguments();
        int itemPosition = arguments.getInt(EXTRA_KEY_POSITION, -1);

        if (0 <= itemPosition){
            BankCardModel bankCard = BankCardManager.getCard(itemPosition);

            cardNumber.setText(bankCard.getNum());
            ownerName.setText(bankCard.getOwnerName());
            expires.setText(bankCard.getDate());
            pin.setText(bankCard.getPin());
            balance.setText(String.format(Locale.getDefault(),"%.2f", bankCard.getBalance()));
        }

    }
}
