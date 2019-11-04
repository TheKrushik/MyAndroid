package com.example.myandroid.lec5;

import java.util.ArrayList;
import java.util.List;

public class BankCardManager {

    private static List<BankCardModel> bankCards = new ArrayList<BankCardModel>(6) {{
        add(new BankCardModel("Danya", "1234 5678 9012 4578",  "21.02.2017", "1234", 1000f));
        add(new BankCardModel("Vanya", "1234 5678 9012 4578",  "21.02.2017", "1234", 1000f));
        add(new BankCardModel("Olya", "1234 5678 9012 4578",  "21.02.2017", "1234", 1000f));
        add(new BankCardModel("Kira", "1234 5678 9012 4578",  "21.02.2017", "1234", 1000f));
        add(new BankCardModel("Misha", "1234 5678 9012 4578",  "21.02.2017", "1234", 1000f));
        add(new BankCardModel("Masyanya", "1234 5678 9012 4578", "21.02.2017", "1234", 1000f));
//        add(new BankCardModel("Mikhalich", "1234 5678 9012 4578",  "21.02.2017", "1234", 1000f));
//        add(new BankCardModel("Lesha", "1234 5678 9012 4578", "21.02.2017", "1234", 1000f));
//        add(new BankCardModel("Vitalik", "1234 5678 9012 4578", "21.02.2017", "1234", 1000f));
    }};


    public static void addBankCard(BankCardModel bankCard) {
        bankCards.add(bankCard);
    }

    public static BankCardModel getCard(int index) {
        return bankCards.get(index);
    }

    public static int getCountCard() {
        return bankCards.size();
    }

    public static List<BankCardModel> getBankCards(){
        return bankCards;
    }
}
