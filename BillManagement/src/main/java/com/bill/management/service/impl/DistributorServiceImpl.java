package com.bill.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.bill.management.repository.DistributorRepository;
import com.bill.management.schema.Distributor;
import com.bill.management.service.DistributorService;

public class DistributorServiceImpl implements DistributorService {

	@Autowired
	private DistributorRepository distributorRepository;
	
	public Distributor saveDistributor(Distributor distributor){
		return distributorRepository.save(distributor);
	}

}
