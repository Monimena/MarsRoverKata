package test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import main.Coordinates;
import main.Direction;
import main.Rotation;
import main.Rover;

public class TestRoverRotation {

	@Test
	void testRotateRightE() {
		Rover testRover = new Rover(new Coordinates(1,1), Direction.E);
		
		testRover.rotate(Rotation.right);
		
		Assert.assertEquals(Direction.S, testRover.getDirection());
	}
	
	@Test
	void testRotateLeftE() {
		Rover testRover = new Rover(new Coordinates(1,1), Direction.E);

		testRover.rotate(Rotation.left);

		Assert.assertEquals(Direction.N, testRover.getDirection());
	}
	
	@Test
	void testRotateRightW() {
		Rover testRover = new Rover(new Coordinates(1,1), Direction.W);
		
		testRover.rotate(Rotation.right);
		
		Assert.assertEquals(Direction.N, testRover.getDirection());
	}
	
	@Test
	void testRotateLeftW() {
		Rover testRover = new Rover(new Coordinates(1,1), Direction.W);

		testRover.rotate(Rotation.left);

		Assert.assertEquals(Direction.S, testRover.getDirection());
	}
	
	@Test
	void testRotateRightN() {
		Rover testRover = new Rover(new Coordinates(1,1), Direction.N);
		
		testRover.rotate(Rotation.right);
		
		Assert.assertEquals(Direction.E, testRover.getDirection());
	}
	
	@Test
	void testRotateLeftN() {
		Rover testRover = new Rover(new Coordinates(1,1), Direction.N);

		testRover.rotate(Rotation.left);

		Assert.assertEquals(Direction.W, testRover.getDirection());
	}
	
	@Test
	void testRotateRightS() {
		Rover testRover = new Rover(new Coordinates(1,1), Direction.S);
		
		testRover.rotate(Rotation.right);
		
		Assert.assertEquals(Direction.W, testRover.getDirection());
	}
	
	@Test
	void testRotateLeftS() {
		Rover testRover = new Rover(new Coordinates(1,1), Direction.S);

		testRover.rotate(Rotation.left);

		Assert.assertEquals(Direction.E, testRover.getDirection());
	}
	
	@Test
	void testDirectionNotSet() {
		Rover testRover = new Rover(new Coordinates(1,1), null);

		testRover.rotate(Rotation.left);

		// check it still has no direction
		Assert.assertEquals(null, testRover.getDirection());
	}
	
	@Test
	void testNullRotation() {
		Rover testRover = new Rover(new Coordinates(1,1), Direction.N);
		
		testRover.rotate(null);

		// check it has not rotated
		Assert.assertEquals(Direction.N, testRover.getDirection());
	}
}
