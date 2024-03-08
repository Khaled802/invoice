package org.example.shop;

import org.example.shop.additonals.NoBallTypeException;

import java.util.Map;

import static java.lang.StringTemplate.STR;

public class SoccerBall extends FootBallShop {
    private static final Map<Integer, TypeInfo> typeMapper = Map.of(
            1, new TypeInfo("Professional Match", 200),
            2, new TypeInfo("Match", 80),
            3, new TypeInfo("Training", 50),
            4, new TypeInfo("Recreational", 20)
    );
    private int ballType;

    public SoccerBall() {
    }

    public SoccerBall(String brand, int quantity, int ballType) {
        super(brand, typeMapper.getOrDefault(ballType, new TypeInfo("", 0)).price(), quantity);
        this.ballType = ballType;
    }

    @Override
    public void display() {
        System.out.println("SOCCER BALL");
        try {
            TypeInfo typeInfo = getTypeInfo();
            System.out.println(STR. """
                Brand: \{ getBrand() }
                Type: \{ ballType }
                Price: \{ getPrice() }
                No Discound!
                Quantity: \{ getQuantity() }
                Subtotal: $\{ calcPrice() }
                """ );
        } catch (NoBallTypeException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public double calcPrice() {
        return this.getPrice() * this.getQuantity();
    }

    @Override
    public double getPrice() {
        try {
            return getTypeInfo().price();
        } catch (NoBallTypeException e) {
            return 0;
        }
    }

    public String getBallTypeName() throws NoBallTypeException {
        return getTypeInfo().name();
    }

    private TypeInfo getTypeInfo() throws NoBallTypeException {
        var typeInfo = typeMapper.get(ballType);
        if (typeInfo == null) throw new NoBallTypeException(
                STR. "\{ ballType } Not valid soccer ball type, Change ball type to valid one");
        return  typeInfo;
    }
}

record TypeInfo(String name, double price) {
}
