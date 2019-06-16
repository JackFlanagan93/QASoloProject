import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import com.bae.persistance.domain.Trainees;
import com.bae.persistance.repository.Classroom_Interface;
import com.bae.persistance.repository.Trainees_Interface;

public class MapTesting {

	/*
	 * Test Plan
	 * Create a Classroom
	 * Remove a Classroom
	 * Update a Classroom
	 * Delete a Classroom
	 * 
	 * Create a Trainee
	 * Remove a Trainee
	 * Update a Trainee
	 * Delete a Trainee
	 * 	
	 */

	@Inject
	Classroom_Interface classroom;
	
	@Inject
	Trainees_Interface trainee;
	
@Before
public void setup() {
		
}

@Test
public void createAClassroom() {
	
	assertEquals("Account Created", classroom.createClassroom("{\"classroomID\":1,\"trainer\":\"Matt Hunt\"}"));
}

@Test
public void createATrainee() {
	
	assertEquals("Account Created", trainee.createTrainee("{\"traineeID\":1,\"traineeName\":\"Test\"}"));
}

@Test
public void deleteTrainee() {
	
	assertEquals("Trainee Removed", trainee.deleteTrainee(1));
}

@Test
public void deleteClassroom() {
	
	assertEquals("Classroom Removed", classroom.deleteClassroom(1));
}


}
