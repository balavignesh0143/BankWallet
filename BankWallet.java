package com.ui;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.bean.TransferDetails;
import com.bean.UserDetails;
import com.service.Calculation;

public class BankWallet {
	public int getOption(Scanner sc)
	{
		try
		{
			int option=sc.nextInt();
			return option;
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			return -1;
		}
	}
	public static void main(String[] args) {
		int option;
		Scanner sc=new Scanner(System.in);
		Calculation c=new Calculation();
		do
		{
			System.out.println("\t\t\t\tXYZ BANK WALLET");
			System.out.println("\n1)Create Account...");
			System.out.println("2)Show Balance...");
			System.out.println("3)Deposit...");
			System.out.println("4)Withdraw...");
			System.out.println("5)Fund Transfer...");
			System.out.println("6)Print Transaction...");
			System.out.println("7)Exit...");
			System.out.println("Enter your option: ");
			option=sc.nextInt();
			switch(option)
			{
			case 1:
				System.out.println("Enter your name:");
				String name=c.validationName(sc.next());
				System.out.println("Enter your mobile number:");
				long mblNo=c.validationMblNo(sc.nextLong());
				Random r=new Random();
				int accNo=r.nextInt(100000000);
				System.out.println("Enter your initial amount: ");
				double balance=c.validationBal((sc.nextDouble()));		
				UserDetails ud=new UserDetails(name, mblNo, accNo, balance);
				c.createAccount(ud);
				System.out.println("Account created....");
				System.out.println("Your name: "+name);
				System.out.println("Your mobile number: "+mblNo);
				System.out.println("Your new account number: "+accNo);
				System.out.println("Your initial balance: "+balance);
				break;
			case 2:
				System.out.println("Enter your account number: ");
				accNo=sc.nextInt();
				double bal=c.showBalance(accNo);
				System.out.println("Current balance: "+bal);
				break;
			case 3:
				System.out.println("Enter your account number: ");
				accNo=sc.nextInt();
				System.out.println("Enter your deposit amount: ");
				double deposit=sc.nextDouble();
				bal=c.depositBalance(accNo,deposit);
				System.out.println("Deposit completed...");
				System.out.println("New balance: "+bal);
				break;
			case 4:
				System.out.println("Enter the account number: ");
				accNo=sc.nextInt();
				System.out.println("Enter your withdraw amount: ");
				double withdraw=sc.nextDouble();
				bal=c.withdrawBalance(accNo,withdraw);
				System.out.println("Withdraw completed....");
				System.out.println("After withdraw current balance: "+bal);
				break;
			case 5:
				System.out.println("Enter your account number: ");
				accNo=sc.nextInt();
				System.out.println("Enter the account number to transfer: ");
				int accNo1=sc.nextInt();
				System.out.println("Enter the transfer amount: ");
				balance=sc.nextDouble();
				bal=c.fundTransfer(accNo,accNo1,balance);
				System.out.println("Transfer completed.....");
				System.out.println("After transaction your current balance is "+bal);
				break;
			case 6:
				System.out.println("Enter the account number: ");
				accNo=sc.nextInt();
				List<?> l=c.printTrans(accNo);
				Iterator<?> i=l.iterator();
				{
					while(i.hasNext())
					{
						TransferDetails td=(TransferDetails) i.next();
						System.out.println("Transaction ID: "+td.getTransId());
						System.out.println("Account from: "+td.getAccNoFrom());
						System.out.println("Account type: "+td.getTransType());
						System.out.println("Account to: "+td.getAccNoTo());
						System.out.println("Date of transaction: "+td.getDateOfTrans());
						System.out.println("Transfer amount: "+td.getTransferAmt());
						System.out.println("Balance: "+td.getBalance());
						
					}
				
				}
				break;
			case 7:
				System.out.println("Thank for using our service!!!");
				System.out.println("Regards\nXYZ BANK WALLET...");
				break;
			default:
				System.out.println("Thanks.....");
				break;
			}
		}while(option!=7);
		sc.close();
	}
}
