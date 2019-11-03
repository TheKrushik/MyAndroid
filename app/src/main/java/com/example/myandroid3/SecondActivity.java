package com.example.myandroid3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.myandroid3.R;

public class SecondActivity extends AppCompatActivity {

    enum Operation {
        ADDITION, SUBTRACTION, MULTIPLY, DIVIDE
    }

    private static final String TAG = "SecondActivity1";
    public static final String ARG_FIRST_PARAM = "firstParam";
    public static final String ARG_SECOND_PARAM = "secondParam";
    public static final String KEY_ARG_OPERATION = "Operation";
    public static final String ARG_RESULT = "result";
    public static final String ERROR = "Не выбрана арифметическая операция";
    public static final String ERROR_DIVIDE_0 = "На 0 делить нельзя";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "onCreate");
        int firstParam = getIntent().getIntExtra(ARG_FIRST_PARAM, 0);
        int secondParam = getIntent().getIntExtra(ARG_SECOND_PARAM, 0);
        Operation operation = (Operation) getIntent().getSerializableExtra(KEY_ARG_OPERATION);


        sendResult(firstParam, secondParam, operation);
    }

    private void sendResult(int firstParam, int secondParam, Operation operation) {
        String stringResult = onCalculate(firstParam, secondParam, operation);
        Log.d(TAG, stringResult);

        if (stringResult.equals(ERROR) || stringResult.equals(ERROR_DIVIDE_0)) {
            setResult(Activity.RESULT_CANCELED, new Intent().putExtra(ARG_RESULT, stringResult));
        } else {
            setResult(Activity.RESULT_OK, new Intent().putExtra(ARG_RESULT, stringResult));
        }
        finish();
    }

    private String onCalculate(int firstParam, int secondParam, Operation operation) {
        switch (operation) {
            case ADDITION:
                return Integer.toString(firstParam + secondParam);
            case SUBTRACTION:
                return Integer.toString(firstParam - secondParam);
            case MULTIPLY:
                return Integer.toString(firstParam * secondParam);
            case DIVIDE:
                try {
                    return Integer.toString(firstParam / secondParam);
                } catch (ArithmeticException e) {
                    e.printStackTrace();
                    return ERROR_DIVIDE_0;
                }
            default:
                return ERROR;
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
