package com.example.myandroid.base;

public interface IMyListener<T> extends BaseRecyclerListener {
//    void onItemClicked(T item);
    void onItemClicked(int position);
}
