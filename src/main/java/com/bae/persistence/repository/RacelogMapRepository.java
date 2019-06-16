package com.bae.persistence.repository;

import javax.enterprise.inject.Alternative;

@Alternative
public class RacelogMapRepository implements Racelog_Interface {

	@Override
	public String getRaceLog() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRaceLogEntry(int entryID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createRaceLogEntry(String raceLogEntry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteRaceLogEntry(int entryID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateRaceLogEntry(int entryID, String raceLogEntry) {
		// TODO Auto-generated method stub
		return null;
	}

}
