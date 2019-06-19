package com.bae.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.bae.persistence.domain.RaceLog;
import com.bae.persistence.domain.Teams;
import com.bae.util.JSONUtil;

@Alternative
public class RacelogMapRepository implements Racelog_Interface {

	Map<Integer, RaceLog> raceLogMap = new HashMap<Integer, RaceLog>();

	@Inject
	JSONUtil util;
	
	@Override
	public String getRaceLog() {
		return util.getJSONForObject(raceLogMap.values());

	}

	@Override
	public String getRaceLogEntry(int entryID) {
		return util.getJSONForObject(raceLogMap.get(entryID));
	}

	@Override
	public String createRaceLogEntry(String raceLogEntry) {
		RaceLog r = util.getObjectForJSON(raceLogEntry, RaceLog.class);
		raceLogMap.put(r.getEntryID(), r);
		return "Race Log Has Been Succesfully Added To The System";
	}

	@Override
	public String deleteRaceLogEntry(int entryID) {
		raceLogMap.remove(entryID);
		return "Race Log Has Been Succesfully Removed From The System";
	}

	@Override
	public String updateRaceLogEntry(int entryID, String raceLogEntry) {
		RaceLog r = util.getObjectForJSON(raceLogEntry, RaceLog.class);
		
		if(raceLogMap.containsKey(entryID)) {
			raceLogMap.replace(entryID, r);
			return "Race Log Has Been Succesfully Updated";
		}
		return "Warning: Race Log Has NOT Been Succefully Updated";
	}

}
