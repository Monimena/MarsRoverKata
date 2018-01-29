package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

/**
 * Simple main class as example app that uses the api
 */
public class Main {
	
	private static final String PROPERTIES_FILE = "mars.properties";
	private static final String EDGE_X_KEY = "edgeX";
	private static final String EDGE_Y_KEY = "edgeY";
	private static final String OBSTACLES_KEY = "obstacles";
	private static final String ROVER_COORDINATES_KEY = "roverCoordinates";
	private static final String ROVER_DIRECTION_KEY = "roverDirection";
	
	private static Rover rover;

	public static void main(String[] args) {
		marsSetup();	
		
		Scanner r = new Scanner(System.in);		
		Commandment commandment = new Commandment(rover);

		System.out.printf("Input command string: ");
		String command = r.nextLine();
		commandment.processCommand(command);
		
		r.close();
	}
	
	private static void marsSetup() {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(PROPERTIES_FILE));
			
			Mars.setEdgeX(Integer.parseInt(properties.getProperty(EDGE_X_KEY)));
			Mars.setEdgeY(Integer.parseInt(properties.getProperty(EDGE_Y_KEY)));
			
			String[] roverCoords = properties.getProperty(ROVER_COORDINATES_KEY).split("-");
			String roverDirection = properties.getProperty(ROVER_DIRECTION_KEY);
			rover = new Rover(new Coordinates(Integer.parseInt(roverCoords[0]), Integer.parseInt(roverCoords[1])), Direction.valueOf(roverDirection));
			
			String[] obstacles = properties.getProperty(OBSTACLES_KEY).split(",");
			for (String obstacle : obstacles) {
				String[] obstacleCoords = obstacle.split("-");
				Coordinates c = new Coordinates(Integer.parseInt(obstacleCoords[0]), Integer.parseInt(obstacleCoords[1]));
				Mars.addObstacle(c);
			}
		  
		} catch (IOException e) {
			System.out.println("Error reading properties file");
		}
	}
}
