package org.example.shop;

import org.example.shop.additonals.DiscConsiderable;

public class Boot extends FootBallShop implements DiscConsiderable {
    private int size;

    public Boot() {
    }

    public Boot(String brand, double price, int quantity, int size) {
        super(brand, price, quantity);
        this.size = size;
    }

    @Override
    public void display() {
        System.out.println(STR."""
                SOCCER BALL
                Brand: \{getBrand()}
                Price: \{getPrice()} for size \{size}
                Discound: %\{RATE * 100}
                Quantity: \{getQuantity()}
                Subtotal: $\{ String.format("%.2f", calcPrice())}
                """);
    }

    @Override
    public double calcPrice() {
        return getPrice() * getQuantity() - calDisc();
    }

    @Override
    public double calDisc() {
        return getPrice() * getQuantity() * RATE;
    }
}
