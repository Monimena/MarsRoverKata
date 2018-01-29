package main;

/**
 * The commandment class is the one in charge of receiving commands, processing them and sending them to the rover.
 * In this case, each commandment commands one rover.
 */
public class Commandment {
	
	private Rover rover;
	
	public Commandment(Rover rover) {
		this.rover = rover;
	}

	public void processCommand(String command) {
		boolean obstacle =  false;
		int i = 0;
		if (command != null && !command.isEmpty()) {
			do {
				char c = command.toCharArray()[i];
				switch(c) {
				case 'f':
					obstacle = rover.move(Movement.forward);
					break;
				case 'b':
					obstacle = rover.move(Movement.backward);
					break;
				case 'l':
					rover.rotate(Rotation.left);
					break;
				case 'r':
					rover.rotate(Rotation.right);
					break;
				default:
					System.out.println("Non-recognized command: " + c);
				}
				
				i++;
			} while (obstacle == false && i < command.toCharArray().length);
			
			System.out.println("Rover current position: " + rover.getCoordinatesString());
			
		} else {
			System.out.println("No command received");
		}
	}

	public Rover getRover() {
		return rover;
	}

	public void setRover(Rover rover) {
		this.rover = rover;
	}
}
