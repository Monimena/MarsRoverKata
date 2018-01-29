package test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import main.Coordinates;
import main.Mars;

public class TestCoordinates {
		
	@Test
	void testForwardX() {
		Coordinates c = new Coordinates(0,0);
		
		c.sumX();
		
		Assert.assertEquals(1, c.getX());
		Assert.assertEquals(0, c.getY());
	}
	
	@Test
	void testBackwardX() {
		Coordinates c = new Coordinates(1,0);
		
		c.subX();
		
		Assert.assertEquals(0, c.getX());
		Assert.assertEquals(0, c.getY());
	}
	@Test
	void testForwardY() {
		Coordinates c = new Coordinates(0,0);
		
		c.sumY();
		
		Assert.assertEquals(0, c.getX());
		Assert.assertEquals(1, c.getY());
	}
	
	@Test
	void testBackwardY() {
		Coordinates c = new Coordinates(0,1);
		
		c.subY();
		
		Assert.assertEquals(0, c.getX());
		Assert.assertEquals(0, c.getY());
	}
	
	@Test
	void testEdgeWrapX0() {
		Coordinates c = new Coordinates(0,0);
		Mars.setEdgeX(25);
		
		c.subX();
		
		Assert.assertEquals(25, c.getX());
		Assert.assertEquals(0, c.getY());
	}
	
	@Test
	void testEdgeWrapX() {
		Coordinates c = new Coordinates(25,0);
		Mars.setEdgeX(25);

		c.sumX();
		
		Assert.assertEquals(0, c.getX());
		Assert.assertEquals(0, c.getY());		
	}
	
	@Test
	void testEdgeWrapY0() {
		Coordinates c = new Coordinates(0,0);
		Mars.setEdgeY(25);
		
		c.subY();
		
		Assert.assertEquals(0, c.getX());
		Assert.assertEquals(25, c.getY());
	}
	
	@Test
	void testEdgeWrapY() {
		Coordinates c = new Coordinates(0,25);
		Mars.setEdgeY(25);
		
		c.sumY();
		
		Assert.assertEquals(0, c.getX());
		Assert.assertEquals(0, c.getY());		
	}
}
