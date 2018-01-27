package main.java;

public class Rover {
	private Coordinates coordinates;	
	private Direction direction;
	
	public Rover(Coordinates c, Direction d) {
		this.coordinates = c;
		this.direction = d;
	}	
	
	public void move(Movement m) {
		if (m == null) {
			System.out.println("Error: movement not set");
			
		} else if (direction == null) {
			System.out.println("Error: direction not set");
			
		} else if (coordinates == null) {
			System.out.println("Error: coordinates not set");
			
		} else if (this.direction == Direction.E && m == Movement.forward || this.direction == Direction.W && m == Movement.backward) {
			this.getCoordinates().setX(this.getCoordinates().getX() + 1);
			
		} else if (this.direction == Direction.E && m == Movement.backward || this.direction == Direction.W && m == Movement.forward) {
			this.getCoordinates().setX(this.getCoordinates().getX() - 1);
			
		} else if (this.direction == Direction.N && m == Movement.forward || this.direction == Direction.S && m == Movement.backward) {
			this.getCoordinates().setY(this.getCoordinates().getY() + 1);
			
		} else if (this.direction == Direction.N && m == Movement.backward || this.direction == Direction.S && m == Movement.forward) {
			this.getCoordinates().setY(this.getCoordinates().getY() - 1);
			
		}
	}

	public void rotate(Rotation r) {
		if (r == null) {
			System.out.println("Error: movement not set");
			
		} else if (direction == null) {
			System.out.println("Error: direction not set");
			
		} else if (this.direction == Direction.E && r == Rotation.left || this.direction == Direction.W && r == Rotation.right) {
			this.setDirection(Direction.N);
			
		} else if (this.direction == Direction.E && r == Rotation.right || this.direction == Direction.W && r  == Rotation.left) {
			this.setDirection(Direction.S);
			
		} else if (this.direction == Direction.N && r  == Rotation.left || this.direction == Direction.S && r == Rotation.right) {
			this.setDirection(Direction.W);
			
		} else if (this.direction == Direction.N && r == Rotation.right || this.direction == Direction.S && r  == Rotation.left) {
			this.setDirection(Direction.E);
			
		}
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates c) {
		this.coordinates = c;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction d) {
		this.direction = d;
	}
}
