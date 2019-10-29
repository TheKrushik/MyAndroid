package com.example.myandroid3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import static com.example.myandroid3.SecondActivity.*;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity1";
    private static final int REQUEST_CODE = 100;

    EditText etFirstNumber, etSecondNumber;
    Button btnAdd, btnSubtract, btnMultiply, btnDivide;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

        findView();

        Button btnMasterDetail = findViewById(R.id.btnMasterDetail);
        btnMasterDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ItemListActivity.class);
                startActivity(intent);

            }
        });
    }

    private void findView() {
        etFirstNumber = findViewById(R.id.etFirstNumber);
        etSecondNumber = findViewById(R.id.etSecondNumber);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        txtResult = findViewById(R.id.txtResult);

        btnAdd.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAdd:
                sendDataFromCalculate(KEY_ARG_ADDITION);
                break;
            case R.id.btnSubtract:
                sendDataFromCalculate(KEY_ARG_SUBTRACTION);
                break;
            case R.id.btnMultiply:
                sendDataFromCalculate(KEY_ARG_MULTIPLY);
                break;
            case R.id.btnDivide:
                sendDataFromCalculate(KEY_ARG_DIVIDE);
                break;
        }
    }

    private void sendDataFromCalculate(String operation) {

        int firstNumber = 0;
        int secondNumber = 0;
        try {
            firstNumber = Integer.parseInt(etFirstNumber.getText().toString());
            secondNumber = Integer.parseInt(etSecondNumber.getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            Toast.makeText(this, "Незаполненое число = 0", Toast.LENGTH_SHORT).show();
        }

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra(ARG_FIRST_PARAM, firstNumber);
        intent.putExtra(ARG_SECOND_PARAM, secondNumber);
        intent.putExtra(KEY_ARG_OPERATION, operation);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (REQUEST_CODE == requestCode && Activity.RESULT_OK == resultCode) {
            if (null != data) {
                String resultExtra = data.getStringExtra(ARG_RESULT);
                txtResult.setText(resultExtra);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }


}
