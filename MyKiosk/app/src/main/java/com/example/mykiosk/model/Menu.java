package com.example.mykiosk.model;

public class Menu {
    int menuImage;
    String menuName;
    String menuPrice;

    public Menu(int menuImage, String menuName, String menuPrice) {
        this.menuImage = menuImage;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
    }

    public int getMenuImage() {
        return menuImage;
    }

    public String getMenuName() {
        return menuName;
    }

    public String getMenuPrice() {
        return menuPrice;
    }
}
