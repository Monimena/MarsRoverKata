package test.java;

import org.junit.jupiter.api.Test;

import org.junit.Assert;
import main.java.Coordinates;
import main.java.Direction;
import main.java.Movement;
import main.java.Rover;

class TestRoverMovement {

	@Test
	void testAdvanceE() {
		Rover testRover = new Rover(new Coordinates(1,1), Direction.E);
		
		testRover.move(Movement.forward);
		
		Assert.assertEquals(2, testRover.getCoordinates().getX());
		Assert.assertEquals(1, testRover.getCoordinates().getY());
	}
	
	@Test
	void testMoveBackE() {
		Rover testRover = new Rover(new Coordinates(1,1), Direction.E);
		
		testRover.move(Movement.backward);

		Assert.assertEquals(0, testRover.getCoordinates().getX());
		Assert.assertEquals(1, testRover.getCoordinates().getY());
	}

	@Test
	void testAdvanceW() {
		Rover testRover = new Rover(new Coordinates(1,1), Direction.W);
		
		testRover.move(Movement.forward);

		Assert.assertEquals(0, testRover.getCoordinates().getX());
		Assert.assertEquals(1, testRover.getCoordinates().getY());
	}
	
	@Test
	void testMoveBackW() {
		Rover testRover = new Rover(new Coordinates(1,1), Direction.W);
		
		testRover.move(Movement.backward);

		Assert.assertEquals(2, testRover.getCoordinates().getX());
		Assert.assertEquals(1, testRover.getCoordinates().getY());
	}
	
	@Test
	void testAdvanceN() {
		Rover testRover = new Rover(new Coordinates(1,1), Direction.N);
		
		testRover.move(Movement.forward);

		Assert.assertEquals(1, testRover.getCoordinates().getX());
		Assert.assertEquals(2, testRover.getCoordinates().getY());
	}
	
	@Test
	void testMoveBackN() {
		Rover testRover = new Rover(new Coordinates(1,1), Direction.N);
		
		testRover.move(Movement.backward);

		Assert.assertEquals(1, testRover.getCoordinates().getX());
		Assert.assertEquals(0, testRover.getCoordinates().getY());
	}
	
	@Test
	void testAdvanceS() {
		Rover testRover = new Rover(new Coordinates(1,1), Direction.S);
		
		testRover.move(Movement.forward);

		Assert.assertEquals(1, testRover.getCoordinates().getX());
		Assert.assertEquals(0, testRover.getCoordinates().getY());
	}
	
	@Test
	void testMoveBackS() {
		Rover testRover = new Rover(new Coordinates(1,1), Direction.S);
		
		testRover.move(Movement.backward);

		Assert.assertEquals(1, testRover.getCoordinates().getX());
		Assert.assertEquals(2, testRover.getCoordinates().getY());
	}
	
	@Test
	void testDirectionNotSet() {
		Rover testRover = new Rover(new Coordinates(1,1), null);
		
		testRover.move(Movement.forward);

		// check it has not moved
		Assert.assertEquals(1, testRover.getCoordinates().getX());
		Assert.assertEquals(1, testRover.getCoordinates().getY());
	}
	
	@Test
	void testCoordinatesNotSet() {
		Rover testRover = new Rover(null, Direction.N);
		
		testRover.move(Movement.forward);

		// check it still has no coordinates
		Assert.assertEquals(null, testRover.getCoordinates());
	}
	
	@Test
	void testNullMovement() {
		Rover testRover = new Rover(new Coordinates(1,1), Direction.N);
		
		testRover.move(null);

		// check it has not moved
		Assert.assertEquals(1, testRover.getCoordinates().getX());
		Assert.assertEquals(1, testRover.getCoordinates().getY());
	}

}
