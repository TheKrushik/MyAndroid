package com.example.myandroid3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity1";
    public static final String ARG_FIRST_PARAM = "firstParam";
    public static final String ARG_SECOND_PARAM = "secondParam";
    public static final String KEY_ARG_OPERATION = "Operation";
    public static final String KEY_ARG_ADDITION = "Addition";
    public static final String KEY_ARG_SUBTRACTION = "Subtraction";
    public static final String KEY_ARG_MULTIPLY = "Multiply";
    public static final String KEY_ARG_DIVIDE = "Divide";
    public static final String ARG_RESULT = "result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "onCreate");
        int firstParam = getIntent().getIntExtra(ARG_FIRST_PARAM, 0);
        int secondParam = getIntent().getIntExtra(ARG_SECOND_PARAM, 0);
        String operation = getIntent().getStringExtra(KEY_ARG_OPERATION);


        String stringResult = "";

        if (operation != null) {
            stringResult = onCalculate(firstParam, secondParam, operation);
        }

        Log.d(TAG, stringResult);

        setResult(Activity.RESULT_OK, new Intent().putExtra(ARG_RESULT, stringResult));
        finish();
    }

    private String onCalculate(int firstParam, int secondParam, String operation) {
        switch (operation) {
            case KEY_ARG_ADDITION:
                return Integer.toString(firstParam + secondParam);
            case KEY_ARG_SUBTRACTION:
                return Integer.toString(firstParam - secondParam);
            case KEY_ARG_MULTIPLY:
                return Integer.toString(firstParam * secondParam);
            case KEY_ARG_DIVIDE:
                try {
                    return Integer.toString(firstParam / secondParam);
                } catch (ArithmeticException e) {
                    e.printStackTrace();
                    return "На 0 делить нельзя";
                }
            default:
                return "Не выбрана арифметическая операция";
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
