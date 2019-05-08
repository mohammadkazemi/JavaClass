package com.company;

public class Account {

    private int         bankID;
    private int         acctNumber;

    private String      customerName;
    private String      acctType;



//    mojodiye hesab
    private double      acctBalance;


    private int         pin;
    private int         stripNumber;

    static int accountNumberIncrementor = 100000;

    Account(int bankID, String customerName, String acctType, double acctBalance, int pin){
        this.bankID         = bankID;
        this.customerName   = customerName;
        this.acctType       = acctType;
        this.acctBalance    = acctBalance;
        this.pin            = pin;
        stripNumber         = generateStripNumber(bankID);
        this.acctNumber     = generateAccountNumber(stripNumber, acctType );
    }









    public int getBankID(){ return bankID; }

    public int getAcctNumber(){ return acctNumber; }

    public String getCustomerName(){ return customerName; }

    public String getAcctType(){ return acctType; }

    public double getAcctBalance(){ return acctBalance; }

    public void setAcctBalance(double newAcctBalance){
        this.acctBalance = newAcctBalance;
    }

    public int getPIN(){ return pin; }

    public int getStripNumber(){ return stripNumber; }






    // Generates strip numbers by adding the bankID to the front
    // of the automatically generated middle part of each account
    // number taken from accountNumberIncrementor

    public int generateStripNumber(int bankID){

        accountNumberIncrementor ++;

        int newStripNumber = (bankID * 1000000) + accountNumberIncrementor;

        return newStripNumber;
    }



    public int generateAccountNumber(int stripNumber, String acctType){

        if((acctType.startsWith("s")) || (acctType.startsWith("S"))){

            // Savings is stripNumber with a 1 at the end

            acctNumber = (stripNumber * 10) + 1;

        } else {

            // Checking is stripNumber with a 2 at the end

            acctNumber = (stripNumber * 10) + 2;
        }

        return acctNumber;

    }





}