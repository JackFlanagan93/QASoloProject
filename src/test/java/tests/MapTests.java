package tests;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.Column;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.bae.persistence.domain.Riders;
import com.bae.persistence.repository.RidersMapRepository;
import com.bae.persistence.repository.Riders_Interface;
import com.bae.util.JSONUtil;

public class MapTests {
	
//	@Inject
//	JSONUtil util;
//	
//	@Inject
//	Riders_Interface Riders;
	
	RidersMapRepository riders = new RidersMapRepository();
	JSONUtil util = new JSONUtil();
	
	@Before
	public void setup() {
		Map<Integer, Riders> ridersMap = new HashMap<Integer, Riders>();
		riders.setUtil(util);
	}

	@Test

	public void createRider() {
		riders.createRider("{\"firstName\":\"Jack\", \"lastName\":\"Flanagan\", \"riderNumber\":55, \"riderTeamID\":55}");	
		assertEquals("Rider Has Been Succesfully Added To The System", riders.createRider("{\"firstName\":\"Jack\", \"lastName\":\"Flanagan\", \"riderNumber\":55, \"riderTeamID\":55}"));
	}

	@Test
	@Ignore
	public void getRiders() {

	}
	
}
