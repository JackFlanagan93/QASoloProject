package com.bae.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.bae.persistence.domain.Teams;
import com.bae.util.JSONUtil;

@Alternative
public class TeamsMapRepository implements Teams_Interface {
	Map<Integer, Teams> teamMap = new HashMap<Integer, Teams>();

	@Inject
	JSONUtil util;
	
	@Override
	public String getTeams() {
		return util.getJSONForObject(teamMap.values());

	}

	@Override
	public String getSingleTeam(int teamID) {
		return util.getJSONForObject(teamMap.get(teamID));
	}

	@Override
	public String createTeam(String team) {
		Teams t = util.getObjectForJSON(team, Teams.class);
		teamMap.put(t.getTeamID(), t);
		return "Team Has Been Succesfully Added To The System";
	}

	@Override
	public String deleteTeam(int teamID) {
		teamMap.remove(teamID);
		return "Team Has Been Succesfully Removed From The System";
	}

	@Override
	public String updateTeam(int teamID, String team) {
		Teams t = util.getObjectForJSON(team, Teams.class);
		
		if(teamMap.containsKey(teamID)) {
			teamMap.replace(teamID, t);
			return "Team Has Been Succesfully Updated";
		}
		return "Warning: Rider Has NOT Been Succefully Updated";
	}

}
