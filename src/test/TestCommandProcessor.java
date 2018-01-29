package test;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import main.Commandment;
import main.Movement;
import main.Rotation;
import main.Rover;

public class TestCommandProcessor {
	
	@Test
	void testCommandMovementForward() {
		Rover testRover = Mockito.mock(Rover.class);
		Commandment testCommand = new Commandment(testRover);
		
		testCommand.processCommand("f");
		
		Mockito.verify(testRover, Mockito.times(1)).move(Movement.forward);
	}
	
	@Test
	void testCommandMovementBackward() {
		Rover testRover = Mockito.mock(Rover.class);
		Commandment testCommand = new Commandment(testRover);
		
		testCommand.processCommand("b");
		
		Mockito.verify(testRover, Mockito.times(1)).move(Movement.backward);
	}
	
	@Test
	void testCommandRotationLeft() {
		Rover testRover = Mockito.mock(Rover.class);
		Commandment testCommand = new Commandment(testRover);
		
		testCommand.processCommand("l");
		
		Mockito.verify(testRover, Mockito.times(1)).rotate(Rotation.left);
	}
	
	@Test
	void testCommandRotationRight() {
		Rover testRover = Mockito.mock(Rover.class);
		Commandment testCommand = new Commandment(testRover);
		
		testCommand.processCommand("r");
		
		Mockito.verify(testRover, Mockito.times(1)).rotate(Rotation.right);
	}
	
	@Test
	void testCommandNull() {
		Rover testRover = Mockito.mock(Rover.class);
		Commandment testCommand = new Commandment(testRover);
		
		testCommand.processCommand(null);
		
		// check it hasn't sent any command
		Mockito.verify(testRover, Mockito.times(0)).rotate(Mockito.any());
		Mockito.verify(testRover, Mockito.times(0)).move(Mockito.any());
	}
	
	@Test
	void testCommandNotRecognized() {
		Rover testRover = Mockito.mock(Rover.class);
		Commandment testCommand = new Commandment(testRover);
		
		testCommand.processCommand(null);

		// check it hasn't sent any command
		Mockito.verify(testRover, Mockito.times(0)).rotate(Mockito.any());
		Mockito.verify(testRover, Mockito.times(0)).move(Mockito.any());
	}
	
	@Test
	void testObstacleDetected() {
		Rover testRover = Mockito.mock(Rover.class);
		Commandment testCommand = new Commandment(testRover);
		
		Mockito.when(testRover.move(Mockito.any())).thenReturn(true);
		
		testCommand.processCommand("fff");
		
		Mockito.verify(testRover, Mockito.times(1)).move(Movement.forward);
	}
}
