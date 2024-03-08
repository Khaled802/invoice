package org.example.customer;

import org.example.shop.FootBallShop;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Customer {
    private String name;
    private Set<FootBallShop> itemList;

    public Customer(String name) {
        this.name = name;
        itemList = new HashSet<>();
    }

    public String getName() {
        return name;
    }
    public double getTotalPay() {
        return itemList.stream().mapToDouble(FootBallShop::calcPrice).sum();
    }
    public int getNumOfItems() {
        return itemList.stream().mapToInt(FootBallShop::getQuantity).sum();
    }
    public void buy(FootBallShop footBallShop) {
        itemList.add(footBallShop);
    }
    public void print() {
        System.out.println("Welcome " + getName());
        System.out.println();
        System.out.println("List of items");
        int itemNumber = 0;
        for (FootBallShop footBallShop : itemList) {
            System.out.println("Item " + ++itemNumber);
            footBallShop.display();
        }
        System.out.println();
        System.out.println("Total cost: " + getTotalPay());
    }
}
