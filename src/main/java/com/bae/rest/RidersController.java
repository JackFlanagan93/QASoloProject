package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.bae.business.RidersService;

@Path("/Riders")
public class RidersController {

	@Inject
	RidersService Riders;

	@Path("/GetRiders")
	@GET
	public String getRiders() {

		return Riders.getRiders();

	}

	@Path("/GetSingleRider/{riderID}")
	@GET
	public String getSingleRider(@PathParam("riderID") int riderID) {
		return Riders.getSingleRider(riderID);
	}

}
