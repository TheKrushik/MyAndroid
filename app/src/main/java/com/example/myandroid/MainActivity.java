package com.example.myandroid;

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

import com.example.myandroid.lec5.MasterActivity;

import static com.example.myandroid.SecondActivity.*;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity1";
    private static final int REQUEST_CODE = 100;

    private EditText etFirstNumber, etSecondNumber;
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

        findView();

//        Button btnMasterDetail = findViewById(R.id.btnMasterDetail);
//        btnMasterDetail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, ItemListActivity.class);
//                startActivity(intent);
//
//            }
//        });

        Button lec4 = findViewById(R.id.lec5);
        lec4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MasterActivity.class);
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
        final int viewID = v.getId();
        switch (viewID) {
            case R.id.btnAdd:
                sendDataFromCalculate(Operation.ADDITION);
                break;
            case R.id.btnSubtract:
                sendDataFromCalculate(Operation.SUBTRACTION);
                break;
            case R.id.btnMultiply:
                sendDataFromCalculate(Operation.MULTIPLY);
                break;
            case R.id.btnDivide:
                sendDataFromCalculate(Operation.DIVIDE);
                break;
        }
    }

    private void sendDataFromCalculate(Operation operation) {

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
        if (REQUEST_CODE == requestCode)
            if (null != data) {
                switch (resultCode) {
                    case Activity.RESULT_OK:
                    case Activity.RESULT_CANCELED: {
                        String resultExtra = data.getStringExtra(ARG_RESULT);
                        txtResult.setText(resultExtra);
                        break;
                    }
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
