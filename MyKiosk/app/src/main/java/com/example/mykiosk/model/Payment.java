package com.example.mykiosk.model;

public class Payment {
    static int orderNumber;
    boolean coupon;
    boolean card;
    int money;
    boolean takeout;

    public Payment(boolean coupon, boolean card, int money, boolean takeout) {
        this.coupon = coupon;
        this.card = card;
        this.money = money;
        this.takeout = takeout;
    }

    void pay(int orderNumber, int money, boolean takeout){
        if(coupon){ //쿠폰 결제

        }else{

        }

    }
}
