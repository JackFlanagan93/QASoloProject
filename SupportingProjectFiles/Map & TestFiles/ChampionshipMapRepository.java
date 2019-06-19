package com.bae.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.bae.persistence.domain.Championship;
import com.bae.util.JSONUtil;

@Alternative
public class ChampionshipMapRepository implements Championship_Interface {

	Map<Integer, Championship> championshipMap = new HashMap<Integer, Championship>();

	@Inject
	JSONUtil util;

	@Override
	public String getChampionship() {
		return util.getJSONForObject(championshipMap.values());
	}

}
