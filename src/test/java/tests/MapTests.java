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
import com.bae.persistence.repository.Riders_Interface;
import com.bae.util.JSONUtil;

public class MapTests {
	
	@Inject
	JSONUtil util;
	@Inject
	Riders_Interface Riders;
	
	@Before
	public void setup() {
		Map<Integer, Riders> ridersMap = new HashMap<Integer, Riders>();
		
	}

	@Test
	@Ignore
	public void createRider() {
		System.out.println("starting createRider Test");
		Riders.createRider("{\"firstName\":\"Jack\", \"lastName\":\"Flanagan\", \"riderNumber\":55, \"riderTeamID\":55 ");
		
		Riders.getRiders();
		
		assertEquals("Rider Has Been Succesfully Added To The System", Riders.createRider("{\"firstName\":\"Jack\", \"lastName\":\"Flanagan\", \"riderNumber\":55, \"riderTeamID\":55 "));
	}

	@Test
	@Ignore
	public void getRiders() {

	}
	
}
