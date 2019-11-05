package com.example.myandroid.model;

public class BankCardModel implements BaseModel {

    private String ownerName;
    private String num;
    private String date;
    private String pin;
    private float balance;

    public BankCardModel(String ownerName, String num, String date, String pin, float balance) {
        this.ownerName = ownerName;
        this.num = num;
        this.date = date;
        this.pin = pin;
        this.balance = balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    @Override
    public String getText1() {
        return getOwnerName();
    }

    @Override
    public String getText2() {
        return getNum();
    }
}
