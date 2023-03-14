package com.ty.shopapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.shopapp.constants.ApplicationConstants;
import com.ty.shopapp.dto.BillCollector;
import com.ty.shopapp.response.ResponseStructure;
import com.ty.shopapp.service.BillCollectorService;

@RestController
public class BillCollectorController {

	@Autowired
	private BillCollectorService billCollectorService;

	@PostMapping("/billCollector")
	public ResponseEntity<ResponseStructure<BillCollector>> saveBillCollector(
			@RequestBody BillCollector billCollector) {
		BillCollector savedProduct = billCollectorService.saveBillCollector(billCollector);
		if (savedProduct != null) {
			ResponseStructure<BillCollector> responseStructure = new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage(ApplicationConstants.BILL_COLLECTOR_ADDED);
			responseStructure.setData(savedProduct);

			ResponseEntity<ResponseStructure<BillCollector>> responseEntity = new ResponseEntity<ResponseStructure<BillCollector>>(
					responseStructure, HttpStatus.CREATED);
			return responseEntity;
		} else {
			ResponseStructure<BillCollector> responseStructure = new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseStructure.setMessage(ApplicationConstants.BILL_COLLECTOR_NOT_ADDED);
			responseStructure.setData(null);

			ResponseEntity<ResponseStructure<BillCollector>> responseEntity = new ResponseEntity<ResponseStructure<BillCollector>>(
					responseStructure, HttpStatus.BAD_REQUEST);
			return responseEntity;
		}
	}
	@GetMapping()
	public void generateBill() {
		
	}
}
