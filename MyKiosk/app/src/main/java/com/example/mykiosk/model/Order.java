package com.example.mykiosk.model;

public class Order {
    int orderQuantity;
    String orderMenu;
    String orderPrice;

    public Order(int orderQuantity, String orderMenu, String orderPrice) {
        this.orderQuantity = orderQuantity;
        this.orderMenu = orderMenu;
        this.orderPrice = orderPrice;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public void setOrderMenu(String orderMenu) {
        this.orderMenu = orderMenu;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public String getOrderMenu() {
        return orderMenu;
    }

    public String getOrderPrice() {
        return orderPrice;
    }
}
