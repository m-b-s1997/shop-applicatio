package com.ty.shopapp.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.shopapp.dao.BillCollectorDao;
import com.ty.shopapp.dto.BillCollector;

@Service
public class BillCollectorService {
	
	@Autowired
	private BillCollectorDao billCollectorDao;

	public BillCollector saveBillCollector(BillCollector billCollector) {
		String name = billCollector.getName();
		long phoneNum = billCollector.getPhoneNumber();
		LocalDate dob = billCollector.getDateOfBirth();
		int last4Digits = (int) (phoneNum%10000);
		int yob = dob.getYear();
		String password = name+"@"+last4Digits+"$"+yob;
		billCollector.setPassword(password);
		return billCollectorDao.saveBillCollector(billCollector);
	}

	public BillCollector searchBillCollector(String billerId) {
		return billCollectorDao.searchBillCollector(billerId);
	}

}
