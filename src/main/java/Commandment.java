package main.java;

public class Commandment {
	
	private Rover rover;
	
	public Commandment(Rover rover) {
		this.rover = rover;
	}

	public void processCommand(String command) {
		if (command != null && !command.isEmpty()) {
			for(char c : command.toCharArray()) {
				switch(c) {
				case 'f':
					rover.move(Movement.forward);
					break;
				case 'b':
					rover.move(Movement.backward);
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
			}
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
