package com.service;

import com.bean.UserDetails;

public interface CalculationInter {
	public void createAccount(UserDetails ud);
	public double showBalance(long accNo);
	public double depositBalance(long accNo,double deposit);
	public double withdrawBalance(long accNo,double withdraw);
	public double fundTransfer(long accNo,long accNo1,double balance);
	//public List<?> printTrans(long accNo);
	
	public String validationName(String name);
	public double validationBal(double balance);
	public long validationMblNo(long mblNo);
}
