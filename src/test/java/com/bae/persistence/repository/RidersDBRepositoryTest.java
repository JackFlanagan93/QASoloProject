package com.bae.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.persistence.domain.Riders;
import com.bae.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class RidersDBRepositoryTest {

	@InjectMocks
	private RidersDBRepository repo;
	
	@Mock
	private EntityManager manager;

	@Mock
	private TypedQuery<Object> query;
	
	private JSONUtil util;
	
	//update
	private static final String MOCK_DATA_ARRAY = "[{\"riderID\":1,\"firstName\":\"Jack\",\"lastName\":\"jackson\",\"riderNumber\":55,\"riderTeamID\":2}]";

	private static final String MOCK_OBJECT = "{\"riderID\":1,\"firstName\":\"Jack\",\"lastName\":\"jackson\",\"riderNumber\":55,\"riderTeamID\":2}";
	
	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}
	
	
	@Test
	public void getRidersTest() {
		
		Mockito.when(manager.createQuery(Mockito.anyString(), Mockito.any())).thenReturn((TypedQuery<Object>) query);
		List<Object> riders = new ArrayList<Object>();
		riders.add(new Riders(1, "Jack", "jackson", 55, 2));
		Mockito.when(query.getResultList()).thenReturn(riders);
//		System.out.println(repo.getRiders());
		Assert.assertEquals(MOCK_DATA_ARRAY, repo.getRiders());
	}
	
	@Test
	public void getSingleRider() {
		Mockito.when(manager.createQuery(Mockito.anyString(), Mockito.any())).thenReturn((TypedQuery<Object>) query);
		List<Object> riders = new ArrayList<Object>();
		riders.add(new Riders(1, "Jack", "jackson", 55, 2));
		Mockito.when(query.getResultList()).thenReturn(riders);
//		System.out.println(repo.getRiders());
		Assert.assertEquals(MOCK_OBJECT, repo.getSingleRider(1));
	}
	
	
	
}
