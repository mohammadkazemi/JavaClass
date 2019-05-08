package com.company;

import java.util.ArrayList;

public class BankComputer {
	
	private int bankID = 9;
	private String bankName ="";
	
	private ArrayList<Account> accounts = new ArrayList<Account>();
	
	public static int numberOfBanks = 0;
	
	BankComputer(String newBankName){
		
		bankName = newBankName;
		
		numberOfBanks++;
		
		this.bankID+= numberOfBanks;
		
	}
	
	public void addAcctToBank(Account newAccount){
		
		this.accounts.add(newAccount);
		
	}
	
	public int getBankID(){ return bankID; }
	
	// Verifies that a card with the strip number is in a bank
	
	public Boolean verifyTheStripNumber(Card theCard){
		
		Boolean cardVerification = false;
		
		for(Account account : accounts){
			
			if(account.getStripNumber() == theCard.getStripNumber()){
				
				cardVerification = true;
				
			}
			
		}
		
		return cardVerification;
		
	}
	
	// Verifies that a card with the strip number and PIN is in a bank
	
	public Boolean verifyThePIN(Transaction theTransaction){
		
		Boolean cardVerification = false;
		
		if(theTransaction.getDidCardVerify()){
		
			for(Account account : accounts){
			
				if((account.getPIN() == theTransaction.getPIN()) && (account.getStripNumber() == theTransaction.getStripNumber())){
				
				cardVerification = true;
				
				theTransaction.setCustomerName(account.getCustomerName());
				
				}
			
			}
			
		}
		
		return cardVerification;
		
	}
	
	public void requestWithdrawalAmt(Transaction theTransaction){
		
		for(Account account : accounts){
			
			if(account.getAcctNumber() == theTransaction.getAccountNumberUsed()){
				
				if(account.getAcctBalance() >= theTransaction.getWithdrawalAmt()){
					
					double newAcctBalance = account.getAcctBalance() - theTransaction.getWithdrawalAmt();
					
					account.setAcctBalance(newAcctBalance);
					
					theTransaction.setAcctBalance(newAcctBalance);
					
				} else {
					
					System.out.println("You can't withdrawal that much money");
					
				}
				
			}
			
		}
		
	}
	
	

}
