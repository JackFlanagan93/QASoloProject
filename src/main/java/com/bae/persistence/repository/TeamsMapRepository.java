package com.bae.persistence.repository;

import javax.enterprise.inject.Alternative;

@Alternative
public class TeamsMapRepository implements Teams_Interface {

	@Override
	public String getTeams() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSingleTeam(int teamID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createTeam(String team) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteTeam(int teamID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateTeam(int teamID, String team) {
		// TODO Auto-generated method stub
		return null;
	}

}
