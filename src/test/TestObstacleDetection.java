package test;

import org.junit.jupiter.api.Test;

import main.Coordinates;
import main.Direction;
import main.Mars;
import main.Movement;
import main.Rover;

import org.junit.Assert;

public class TestObstacleDetection {
	
	@Test
	void testObstacleX() {
		Mars.addObstacle(new Coordinates(1,0));
		
		Rover rover = new Rover(new Coordinates(0,0), Direction.E);
		boolean collision = rover.move(Movement.forward);
		
		Assert.assertEquals(true, collision);
		Assert.assertEquals(0, rover.getCoordinates().getX());
		Assert.assertEquals(0, rover.getCoordinates().getY());
	}
	
	@Test
	void testObstacleY() {
		Mars.addObstacle(new Coordinates(0,1));
		
		Rover rover = new Rover(new Coordinates(0,0), Direction.N);
		boolean collision = rover.move(Movement.forward);
		
		Assert.assertEquals(true, collision);
		Assert.assertEquals(0, rover.getCoordinates().getX());
		Assert.assertEquals(0, rover.getCoordinates().getY());
	}	
}
