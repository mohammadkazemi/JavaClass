package com.company;

public class Customer {

    private Card customersATMCard;

    // Replaces public Card insertATMCard()

    Customer(Card newATMCard){

        customersATMCard = newATMCard;

    }

    public Card getATMCard() { return customersATMCard; }

}