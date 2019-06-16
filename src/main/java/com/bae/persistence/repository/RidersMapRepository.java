package com.bae.persistence.repository;

import javax.enterprise.inject.Alternative;

@Alternative
public class RidersMapRepository implements Riders_Interface {

	@Override
	public String getRiders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSingleRider(int riderID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createRider(String rider) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteRider(int riderID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateRider(int riderID, String rider) {
		// TODO Auto-generated method stub
		return null;
	}

}
