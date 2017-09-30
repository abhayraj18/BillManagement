package com.bill.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bill.management.pojo.DistributorVO;
import com.bill.management.schema.Distributor;
import com.bill.management.service.DistributorService;
import com.bill.management.utils.ResponseUtils;

@RestController
@RequestMapping("/distributor")
public class DistributorController {
	
	@Autowired
	private DistributorService distributorService;
	
	@RequestMapping(value = "/add")
	public ResponseEntity<String> addDistributor(DistributorVO distributorVO){
		ResponseEntity<String> entity = null;
		if(distributorVO == null){
			entity = new ResponseEntity<String>("Please send the details", HttpStatus.BAD_REQUEST);
			return entity;
		}
		
		if(distributorVO.getName() == null || distributorVO.getName().equals("")){
			entity = new ResponseEntity<String>("Name is mandatory", HttpStatus.BAD_REQUEST);
		}
		
		if(distributorVO.getContact() == null || distributorVO.getContact().equals("")){
			entity = new ResponseEntity<String>("Contact is mandatory", HttpStatus.BAD_REQUEST);
		}
		
		Distributor distributor = new Distributor();
		distributor.setName(distributorVO.getName());
		distributor.setContact(distributorVO.getContact());
		distributor.setAddress(distributorVO.getAddress());
		distributor = distributorService.saveDistributor(distributor);
		
		distributorVO.setId(distributor.getId());
		entity = new ResponseEntity<String>(ResponseUtils.convertPOJOToString(distributorVO), HttpStatus.OK);
		return entity;
	}
	
}
