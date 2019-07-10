package com.service;

import java.util.List;
import java.util.Scanner;

import com.bean.UserDetails;
import com.dao.Store;

public class Calculation implements CalculationInter {
	
	Scanner sc = new Scanner(System.in);
	Store s=new Store();

	public void createAccount(UserDetails ud) 
	{
		s.createAccount(ud);	
	}
	
	public double showBalance(long accNo)
	{
		return s.showBalance(accNo);
	}
	
	public double depositBalance(long accNo,double deposit) 
	{
		return s.depositBalance(accNo,deposit);
	}
	
	public double withdrawBalance(long accNo,double withdraw)
	{
		return s.withdrawBalance(accNo,withdraw);
	}
	
	public double fundTransfer(long accNo,long accNo1,double balance)
	{
		return s.fundTransfer(accNo,accNo1,balance);
	}
	
	public List<?> printTrans(long accNo)
	{
		return s.printTrans(accNo);
	}
	
	public double validationBal(double balance)
	{
		while(true)
			{
				if(balance<=0)
				{
					System.out.println("Amount is lesser than zero...");
					System.out.println("Enter the amount again: ");
					balance=sc.nextDouble();
				}
				else
				{
					return balance;
				}
		}		
	}
	
	public String validationName(String name)
	{
		if(name.matches("[A-Z][a-zA-Z]*"))
				return name;
		else
			System.out.println("Enter valid name: ");
			return name=sc.next();
	}
	
	public long validationMblNo(long mblNo)
	{
		while(true)
		{
			if(String.valueOf(mblNo).length()==10)
			{
				System.out.println(mblNo);
				return mblNo;
			}
			else
			{
				System.out.println("Enter the valid mobile number: ");
				mblNo=sc.nextLong();
			}
		}
	}



	
}
