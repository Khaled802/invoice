package org.example.shop;

public abstract class FootBallShop {
    private String brand;
    private double price;
    private int quantity;

    public FootBallShop() {}

    public FootBallShop(String brand, double price, int quantity) {
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract void display();
    public abstract double calcPrice();
    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
