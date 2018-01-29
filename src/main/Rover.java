package main;

/**
 * The rover class represents one rover. It has a position and is facing a direction. It can move and rotate.
 * The rover always receives initial position & direction 
 */
public class Rover {
	private Coordinates coordinates;	
	private Direction direction;
	
	public Rover(Coordinates c, Direction d) {
		this.coordinates = c;
		this.direction = d;
	}
	
	public boolean move(Movement m) {
		if (m == null) {
			System.out.println("Error: movement not set");
			
		} else if (direction == null) {
			System.out.println("Error: direction not set");
			
		} else if (coordinates == null) {
			System.out.println("Error: coordinates not set");
			
		} else if (direction == Direction.E && m == Movement.forward || direction == Direction.W && m == Movement.backward) {
			Coordinates newCoordinates = new Coordinates(coordinates.getX() + 1, coordinates.getY());
			if (Mars.isObstacle(newCoordinates)) {
				System.out.println("Obstacle detected at " + newCoordinates.toString() + ". Aborting");
				return true;
			} else {
				coordinates.sumX();
			}
			
		} else if (direction == Direction.E && m == Movement.backward || direction == Direction.W && m == Movement.forward) {
			Coordinates newCoordinates = new Coordinates(coordinates.getX() - 1, coordinates.getY());
			if (Mars.isObstacle(newCoordinates)) {
				System.out.println("Obstacle detected at " + newCoordinates.toString() + ". Aborting");
				return true;
			} else {
				coordinates.subX();
			}
			
		} else if (direction == Direction.N && m == Movement.forward || direction == Direction.S && m == Movement.backward) {
			Coordinates newCoordinates = new Coordinates(coordinates.getX(), coordinates.getY() + 1);
			if (Mars.isObstacle(newCoordinates)) {
				System.out.println("Obstacle detected at " + newCoordinates.toString() + ". Aborting");
				return true;
			} else {
				coordinates.sumY();
			}
			
		} else if (direction == Direction.N && m == Movement.backward || direction == Direction.S && m == Movement.forward) {
			Coordinates newCoordinates = new Coordinates(coordinates.getX(), coordinates.getY() - 1);
			if (Mars.isObstacle(newCoordinates)) {
				System.out.println("Obstacle detected at " + newCoordinates.toString() + ". Aborting");
				return true;
			} else {
				coordinates.subY();
			}
			
		}
		
		return false;
	}

	public void rotate(Rotation r) {
		if (r == null) {
			System.out.println("Error: movement not set");
			
		} else if (direction == null) {
			System.out.println("Error: direction not set");
			
		} else if (direction == Direction.E && r == Rotation.left || direction == Direction.W && r == Rotation.right) {
			direction = Direction.N;
			
		} else if (direction == Direction.E && r == Rotation.right || direction == Direction.W && r  == Rotation.left) {
			direction = Direction.S;
			
		} else if (direction == Direction.N && r  == Rotation.left || direction == Direction.S && r == Rotation.right) {
			direction = Direction.W;
			
		} else if (direction == Direction.N && r == Rotation.right || direction == Direction.S && r  == Rotation.left) {
			direction = Direction.E;
			
		}
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}
	
	public String getCoordinatesString() {
		return coordinates.toString();
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
