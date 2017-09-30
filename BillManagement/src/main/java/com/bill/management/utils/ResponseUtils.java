package com.bill.management.utils;

import com.bill.management.pojo.DistributorVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseUtils {

	public static String convertPOJOToString(DistributorVO distributorVO) {
		String result = "";
		try {
			result = new ObjectMapper().writeValueAsString(distributorVO);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}

}
