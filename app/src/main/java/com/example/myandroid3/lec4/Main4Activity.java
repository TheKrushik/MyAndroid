package com.example.myandroid3.lec4;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.example.myandroid3.R;

import java.util.ArrayList;
import java.util.List;

public class Main4Activity extends AppCompatActivity {

    RecyclerView rvBankCard;
    List<BankCard> bankCardList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        bankCardList.add(new BankCard("Danya", "1234 5678 9012 4578", 1000f, "21.02.2017", "1234"));
        bankCardList.add(new BankCard("Vanya", "1234 5678 9012 4578", 1000f, "21.02.2017", "1234"));
        bankCardList.add(new BankCard("Olya", "1234 5678 9012 4578", 1000f, "21.02.2017", "1234"));
        bankCardList.add(new BankCard("Kira", "1234 5678 9012 4578", 1000f, "21.02.2017", "1234"));
        bankCardList.add(new BankCard("Misha", "1234 5678 9012 4578", 1000f, "21.02.2017", "1234"));
        bankCardList.add(new BankCard("Masyanya", "1234 5678 9012 4578", 1000f, "21.02.2017", "1234"));
        bankCardList.add(new BankCard("Mikhalich", "1234 5678 9012 4578", 1000f, "21.02.2017", "1234"));
        bankCardList.add(new BankCard("Lesha", "1234 5678 9012 4578", 1000f, "21.02.2017", "1234"));
        bankCardList.add(new BankCard("Vitalik", "1234 5678 9012 4578", 1000f, "21.02.2017", "1234"));


        rvBankCard = findViewById(R.id.rvBankCard);
        rvBankCard.setAdapter(new BankCardAdapter(bankCardList));
        rvBankCard.setLayoutManager(new LinearLayoutManager(this));
    }
}
