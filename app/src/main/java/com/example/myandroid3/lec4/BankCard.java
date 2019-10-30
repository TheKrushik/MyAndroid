package com.example.myandroid3.lec4;

public class BankCard {

    private String ownerName;
    private String num;
    private float amount;
    private String date;
    private String pin;

    public BankCard(String ownerName, String num, float amount, String date, String pin) {
        this.ownerName = ownerName;
        this.num = num;
        this.amount = amount;
        this.date = date;
        this.pin = pin;
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

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
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
}
