package com.bean;

public class UserDetails {
	private String name;
	private long mblNo;
	private double balance;
	private double deposit;
	private double withdraw;
	private int accNo;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMblNo() {
		return mblNo;
	}
	public void setMblNo(long mblNo) {
		this.mblNo = mblNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public double getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}
	
	public long getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public UserDetails(String name,long mblNo,int accNo,double balance)
	{
		this.accNo=accNo;
		this.name=name;
		this.mblNo=mblNo;
		this.balance=balance;
	}
}