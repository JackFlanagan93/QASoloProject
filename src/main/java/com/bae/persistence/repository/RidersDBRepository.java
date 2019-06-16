package com.bae.persistence.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.bae.persistence.domain.Riders;
import com.bae.util.JSONUtil;

@Default
public class RidersDBRepository implements Riders_Interface {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Override
	public String getRiders() {
		Query query = manager.createQuery("SELECT r FROM Riders r", Riders.class);
		return util.getJSONForObject(query.getResultList());

	}

	@Override
	public String getSingleRider(int riderID) {
		return util.getJSONForObject(manager.find(Riders.class, riderID));
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
