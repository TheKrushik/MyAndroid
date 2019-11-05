package com.example.myandroid.lec5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myandroid.R;
import com.example.myandroid.data.BankCardManager;
import com.example.myandroid.model.BankCardModel;

public class AddCardActivity extends AppCompatActivity implements View.OnClickListener {

    EditText cardNumber, ownerName, expires, pin;
    Button addCardBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        cardNumber = findViewById(R.id.cardNumber);
        ownerName = findViewById(R.id.ownerName);
        expires = findViewById(R.id.expires);
        pin = findViewById(R.id.pin);

        addCardBtn = findViewById(R.id.addCardBtn);
        addCardBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String ownerNameStr = ownerName.getText().toString();
        String cardNumberStr = cardNumber.getText().toString();
        String expiresStr = expires.getText().toString();
        String pinStr = pin.getText().toString();
        BankCardModel bankCard = new BankCardModel(ownerNameStr, cardNumberStr, expiresStr, pinStr, 0f);

        BankCardManager.addBankCard(bankCard);

        finish();
    }
}
