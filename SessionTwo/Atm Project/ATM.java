package com.company;
import java.util.Scanner;

public class ATM {

    private Transaction theTransaction = null;
    private BankNetwork networkOfBanksOnATM = null;

    // Used to get input from the customer

    static Scanner userInput = new Scanner(System.in);

    ATM(BankNetwork networkOfBanksOnATM){

        this.networkOfBanksOnATM = networkOfBanksOnATM;

    }

    public boolean isStripReadable(Card theCard){

        // Returns the number of digits in stripNumber

        int numberOfDigitsInStrip = (int) (Math.log10(theCard.getStripNumber())+1);

        theTransaction = new Transaction(theCard.getStripNumber());

        if(numberOfDigitsInStrip == 10){

            return true;

        } else {

            return false;
        }

    }

    // Sends the card inserted to BankNetwork to see if there
    // are any matching bankIDs

    public boolean isATMCardsBankInNetwork(Card theCard){

        if(networkOfBanksOnATM.isATMCardsBankInNetwork(theCard)){

            theTransaction.setStripNumber(theCard.getStripNumber());

            // Sets that the stripNumber has been verified so it is ok
            // to access account info to verify pin later

            theTransaction.setDidTheCardVerify(true);

            return true;

        } else {

            return false;

        }

    }

    public boolean insertPIN(Card theCard, int pin){

        // Finds the number of digits in the PIN

        int numberOfDigitsInPIN = (int) (Math.log10(pin)+1);

        if(numberOfDigitsInPIN != 4){

            System.out.println("You have to enter 4 digits for a PIN");

            return false;

        } else {

            theTransaction.setPIN(pin);


            // I decided to pass the transaction instead of the card
            // like I did in the sequence diagram

            networkOfBanksOnATM.verifyThePIN(theTransaction);

        }

        return false;

    }

    public void pickAcctToAccess(){

        System.out.println("What Account do you Want to Withdrawal From ");
        System.out.println("( 1 - Savings, 2 - Checking ) ");

        if (userInput.hasNextInt()){

            int numberEntered = userInput.nextInt();

            theTransaction.setAcctToWithdrawalFrom(numberEntered);

        } else {

            System.out.println("You Entered an Invalid Option");

        }

    }

    public void amountToWithdrawal(){

        System.out.println("How much do you want to withdrawal ");
        System.out.println("( Increments of 10 ) ");

        if (userInput.hasNextInt()){

            int numberEntered = userInput.nextInt();

            theTransaction.setWithdrawalAmt(numberEntered);

            networkOfBanksOnATM.requestWithdrawalAmt(theTransaction);

        } else {

            System.out.println("You Entered an Invalid Amount");

        }

    }

    public void getTransactionInfo(){

        System.out.println("Thank you " + theTransaction.getCustomerName() + " for using the XYZ Bank ATM\n");

        System.out.println("Date / Time of Transaction: " + theTransaction.getCurrentDateTime());
        System.out.println("\nTransaction");

        System.out.print("Removed $" + theTransaction.getWithdrawalAmt() + " from your ");

        if(theTransaction.getAcctToWithdrawalFrom() == 1){

            System.out.println("Savings Account.\nYour current balance is " + theTransaction.getAcctBalance());

        } else {

            System.out.println("Checking Account.\nYour current balance is " + theTransaction.getAcctBalance());

        }

    }

}