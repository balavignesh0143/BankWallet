package com.dao;

import java.util.List;

import com.bean.TransferDetails;
import com.bean.UserDetails;

public interface StoreInter {
	public void addDetails(UserDetails ud);
	public void transferDetails(TransferDetails td);
	
	public void createAccount(UserDetails ud);
	public double showBalance(long accNo);
	
	public double depositBalance(long accNo,double deposit);
	public double withdrawBalance(long accNo, double withdraw);
	public double fundTransfer(long accNo,long accNo1,double balance);
	public List<TransferDetails> printTrans(long accNo);
}
