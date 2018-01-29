package main;

/**
 * Coordinates for the rover & obstacles
 */
public class Coordinates {
	private int x;
	private int y;
	
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void sumX() {
		if (x < Mars.getEdgeX()) {
			x++;
		} else {
			x = 0;
		}
	}

	public void sumY() {
		if (y < Mars.getEdgeY()) {
			y++;	
		} else {
			y = 0;
		}
	}

	public void subX() {
		if (x > 0) {
			x--;
		} else {
			x = Mars.getEdgeX();
		}
	}
	
	public void subY() {
		if (y > 0) {
			y--;
		} else {
			y = Mars.getEdgeY();
		}
	}

	@Override
	public String toString() {
		return "Coordinates [x=" + x + ", y=" + y + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Coordinates)) {
			return false;
		}
		Coordinates other = (Coordinates) obj;
		if (x != other.x) {
			return false;
		}
		if (y != other.y) {
			return false;
		}
		return true;
	}
}
