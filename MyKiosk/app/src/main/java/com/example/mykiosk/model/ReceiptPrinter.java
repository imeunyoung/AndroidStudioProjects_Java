package com.example.mykiosk.model;

public class ReceiptPrinter {

    Receipt receipt; //영수증
    int totalAmount;    //결제금액
    String totalMenu; //결제메뉴
    int orderNumber; //주문번호

}
    public ReceiptPrinter(int totalAmount,int orderNumber,String totalMenu) {
        this.totalAmount=totalAmount;
        this.orderNumber=orderNumber;
        this.totalMenu=totalMenu;
    }

    String printReceipt(){

