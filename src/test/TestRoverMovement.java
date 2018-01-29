package test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import main.Coordinates;
import main.Direction;
import main.Mars;
import main.Movement;
import main.Rover;

class TestRoverMovement {

	@Test
	void testAdvanceE() {
		Mars.setEdgeX(25);
		Rover testRover = new Rover(new Coordinates(1,1), Direction.E);
		
		testRover.move(Movement.forward);
		
		Assert.assertEquals(2, testRover.getCoordinates().getX());
		Assert.assertEquals(1, testRover.getCoordinates().getY());
	}
	
	@Test
	void testMoveBackE() {
		Mars.setEdgeX(25);
		Rover testRover = new Rover(new Coordinates(1,1), Direction.E);
		
		testRover.move(Movement.backward);

		Assert.assertEquals(0, testRover.getCoordinates().getX());
		Assert.assertEquals(1, testRover.getCoordinates().getY());
	}

	@Test
	void testAdvanceW() {
		Mars.setEdgeX(25);
		Rover testRover = new Rover(new Coordinates(1,1), Direction.W);
		
		testRover.move(Movement.forward);

		Assert.assertEquals(0, testRover.getCoordinates().getX());
		Assert.assertEquals(1, testRover.getCoordinates().getY());
	}
	
	@Test
	void testMoveBackW() {
		Mars.setEdgeX(25);
		Rover testRover = new Rover(new Coordinates(1,1), Direction.W);
		
		testRover.move(Movement.backward);

		Assert.assertEquals(2, testRover.getCoordinates().getX());
		Assert.assertEquals(1, testRover.getCoordinates().getY());
	}
	
	@Test
	void testAdvanceN() {
		Mars.setEdgeY(25);
		Rover testRover = new Rover(new Coordinates(1,1), Direction.N);
		
		testRover.move(Movement.forward);

		Assert.assertEquals(1, testRover.getCoordinates().getX());
		Assert.assertEquals(2, testRover.getCoordinates().getY());
	}
	
	@Test
	void testMoveBackN() {
		Mars.setEdgeY(25);
		Rover testRover = new Rover(new Coordinates(1,1), Direction.N);
		
		testRover.move(Movement.backward);

		Assert.assertEquals(1, testRover.getCoordinates().getX());
		Assert.assertEquals(0, testRover.getCoordinates().getY());
	}
	
	@Test
	void testAdvanceS() {
		Mars.setEdgeY(25);
		Rover testRover = new Rover(new Coordinates(1,1), Direction.S);
		
		testRover.move(Movement.forward);

		Assert.assertEquals(1, testRover.getCoordinates().getX());
		Assert.assertEquals(0, testRover.getCoordinates().getY());
	}
	
	@Test
	void testMoveBackS() {
		Mars.setEdgeY(25);
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
