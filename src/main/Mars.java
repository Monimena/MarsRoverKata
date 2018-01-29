package main;

import java.util.HashMap;

/**
 * This class represents the planet Mars with its surface size and obstacles
 */
public class Mars {
	
	private static int edgeX;
	private static int edgeY;
	
	private static HashMap<Coordinates, Boolean> obstacles;
	
	public Mars () {
		
	}

	public static int getEdgeX() {
		return edgeX;
	}

	public static void setEdgeX(int edgeX) {
		Mars.edgeX = edgeX;
	}

	public static int getEdgeY() {
		return edgeY;
	}

	public static void setEdgeY(int edgeY) {
		Mars.edgeY = edgeY;
	}

	public static void addObstacle(Coordinates c) {
		if (obstacles == null) {
			obstacles = new HashMap<>();
		}
		
		obstacles.put(c, true);
	}
	
	public static boolean isObstacle(Coordinates c) {
		if (obstacles != null) {
			Boolean isObstacle = obstacles.get(c);
			if (isObstacle != null && isObstacle == true) {
				return true;
			}
		}
		
		return false;
	}
}
