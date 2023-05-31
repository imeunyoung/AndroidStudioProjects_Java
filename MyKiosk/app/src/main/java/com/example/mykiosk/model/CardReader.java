package com.example.mykiosk.model;

public class CardReader {
    int card_number;
    int card_money=30000;
    int money;

//    boolean readCard(int card_number,int money){
//        this.card_money=card_number;
//        this.money=money;
//
//        if(!validCard(card_number)){
//
//        }
//
//        if(!cashLeft(card_number)){
//
//        }
//        else{
//
//        }
//
//
//    }
    boolean validCard(int card_number){//카드 번호가 유효한지 확인
        if(card_number==0){  //카드번호가 0 이면 오류
            return false;
        }
        else return true;
    }
    boolean cashLeft(int card_number){ //카드에 잔액이 주문 금액보다 큰지 확인
        if(this.money<card_money){
            return true;
        }else{
            return false;
        }
    }

}
