package org.example;

import org.example.customer.Customer;
import org.example.shop.Boot;
import org.example.shop.FootBallShop;
import org.example.shop.SoccerBall;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        FootBallShop p1 = new SoccerBall("Adidas", 3, 2);
        FootBallShop p2 = new Boot("PUMA", 49.00, 3, 42);
        FootBallShop p3 = new Boot("NIKE", 50.00, 5, 46);
        FootBallShop p4 = new SoccerBall("PUMA", 4, 5);
        Customer customer = new Customer("Jemmy Tomas");
        customer.buy(p1);
        customer.buy(p2);
        customer.buy(p3);
        customer.buy(p4);
        customer.print();
    }
}