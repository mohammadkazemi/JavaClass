package com.company;

public class TestATM {

    public static void main(String[] args){

        // Create a new account for a customer

        Account theAccount = new Account(10, "Derek Banas", "C", 10000.00, 1234);

        // Generate an ATM card for the new customer

        Card customersATMCard = new Card(theAccount.getPIN(), theAccount.getStripNumber());

        // Create the Customer object and give it an ATM card

        Customer theCustomer = new Customer(customersATMCard);

        // Create the BankComputer that will hold the account

        BankComputer xyzBankComputer = new BankComputer("XYZ Bank");

        // Add the customer account to the bank computer

        xyzBankComputer.addAcctToBank(theAccount);

        // Create a network that will hold every bank computer and all
        // the accounts they hold

        BankNetwork theBankNetwork = new BankNetwork();

        // Add the BankComputer to the BankNetwork

        theBankNetwork.addBankToNetwork(xyzBankComputer);

        // Create the ATM machine that will allow access to all
        // BankComputers in the BankNetwork

        ATM mainStreetATM = new ATM(theBankNetwork);

        // Check with the ATM to find out if the card is readable

        mainStreetATM.isStripReadable(customersATMCard);

        // Check with the BankNetwork to see if the cards member
        // bank is part of the network

        mainStreetATM.isATMCardsBankInNetwork(customersATMCard);

        // customersATMCard and the PIN are verified by the ATM

        mainStreetATM.insertPIN(customersATMCard, 1234);

        // Asks the customer whether to withdrawal money from checking or savings

        mainStreetATM.pickAcctToAccess();

        // Asks the customer how much money they want to withdrawal

        mainStreetATM.amountToWithdrawal();

        // Provides information on the transaction

        mainStreetATM.getTransactionInfo();

    }



}