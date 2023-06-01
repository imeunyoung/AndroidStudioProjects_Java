package com.example.mykiosk.model;

import java.util.ArrayList;
import java.util.Objects;

public class Order {

    int orderQuantity;
    String orderMenu;
    String unitAmount;

    String totalAmount;


    public Order(int orderQuantity, String orderMenu, String unitAmount) {
        this.orderQuantity = orderQuantity;
        this.orderMenu = orderMenu;
        this.unitAmount=unitAmount;
        this.totalAmount= String.valueOf(Integer.parseInt(unitAmount)*orderQuantity);
    }
    public static String getTotalQuantity(ArrayList<Order> orderList) {
        int totalQuantity = 0;
        for (Order order : orderList) {
            totalQuantity += order.getOrderQuantity();
        }
        return String.valueOf(totalQuantity);
    }

    public static String getTotalPrice(ArrayList<Order> orderList) {
        Integer totalPrice = 0;
        for (Order order : orderList) {
            totalPrice += Integer.parseInt(order.getTotalAmount());
        }
        return String.valueOf(totalPrice);
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public String getOrderMenu() {
        return orderMenu;
    }

    public String getUnitAmount() {
        return unitAmount;
    }

    public String getTotalAmount() {
        return totalAmount;
    }
}
