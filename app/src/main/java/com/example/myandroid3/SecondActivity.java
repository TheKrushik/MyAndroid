package com.example.myandroid3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";
    public static final String ARG_FIRST_PARAM = "firstParam";
    public static final String ARG_SECOND_PARAM = "secondParam";
    public static final String ARG_RESULT = "result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "onCreate");
        int firstParam = getIntent().getIntExtra(ARG_FIRST_PARAM, 0);
        int secondParam = getIntent().getIntExtra(ARG_SECOND_PARAM, 0);

        int value = firstParam + secondParam;
        Log.d(TAG, Integer.toString(value));

        setResult(Activity.RESULT_OK, new Intent().putExtra(ARG_RESULT, value));
        finish();
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
