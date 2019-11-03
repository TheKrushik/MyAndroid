package com.example.myandroid3.lec5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myandroid3.R;
import com.example.myandroid3.lec5.BankCardModel;
import com.example.myandroid3.lec5.BankCardManager;

import java.util.Locale;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_KEY_POSITION = "extra_key_position";

    TextView cardNumber, ownerName, expires, pin, balance;
    BankCardModel bankCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        cardNumber = findViewById(R.id.cardNumber);
        ownerName = findViewById(R.id.ownerName);
        expires = findViewById(R.id.expires);
        pin = findViewById(R.id.pin);
        balance = findViewById(R.id.balance);

        int itemPosition = getIntent().getIntExtra(EXTRA_KEY_POSITION, -1);

        if (0 > itemPosition)
            finish();

        bankCard = BankCardManager.getCard(itemPosition);

        cardNumber.setText(bankCard.getNum());
        ownerName.setText(bankCard.getOwnerName());
        expires.setText(bankCard.getDate());
        pin.setText(bankCard.getPin());
        balance.setText(String.format(Locale.getDefault(),"%.2f", bankCard.getBalance()));

    }
}
