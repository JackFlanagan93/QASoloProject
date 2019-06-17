package com.bae.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.bae.persistence.domain.Riders;
import com.bae.util.JSONUtil;

@Alternative
public class RidersMapRepository implements Riders_Interface {

	Map<Integer, Riders> ridersMap = new HashMap<Integer, Riders>();
	
	@Inject
	JSONUtil util;
	
	@Override
	public String getRiders() {
		return util.getJSONForObject(ridersMap.values());
	}

	@Override
	public String getSingleRider(int riderID) {
		return util.getJSONForObject(ridersMap.get(riderID));
	}

	@Override
	public String createRider(String rider) {
		Riders r = util.getObjectForJSON(rider, Riders.class);
		ridersMap.put(r.getRiderID(), r);
		return "Rider Has Been Succesfully Added To The System";
	}

	@Override
	public String deleteRider(int riderID) {
		ridersMap.remove(riderID);
		return "Rider Has Been Succesfully Removed From The System";
	}

	@Override
	public String updateRider(int riderID, String rider) {
		Riders r = util.getObjectForJSON(rider, Riders.class);
		
		if(ridersMap.containsKey(riderID)) {
			ridersMap.replace(riderID, r);
			return "Rider Has Been Succesfully Updated";
			
		}
		return "Warning: Rider Has NOT Been Succesfully Updated!";
	}

}
