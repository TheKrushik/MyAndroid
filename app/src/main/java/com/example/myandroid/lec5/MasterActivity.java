package com.example.myandroid.lec5;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myandroid.R;

public class MasterActivity extends AppCompatActivity implements MasterFragment.IMainFragment {

    private static final String TAG = "MasterActivity";

    FrameLayout rootView, detailRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);
        rootView = findViewById(R.id.root);
        detailRoot = findViewById(R.id.detail);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.root, MasterFragment.newInstance().setListener(this))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onItemClick(int position) {
        int viewId = null != detailRoot ? R.id.detail : R.id.root;
        getSupportFragmentManager().beginTransaction()
                .replace(viewId, DetailCardFragment.newInstance(position))
                .addToBackStack(null)
                .commit();
    }
}
