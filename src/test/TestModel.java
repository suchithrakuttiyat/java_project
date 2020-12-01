package test;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import model.Car;
import model.Limo;
import model.SmallCar;
import model.Truck;

public class TestModel {

	private Car smallCar;
	private Car truck;
	private Car limo;
	
	@Before
    public void setUp() {
		 smallCar = new SmallCar(new Point(2,2), "North");
		 truck = new Truck(new Point(2,2), "North");
		 limo = new Limo(new Point(2,2), "North");
    }

	@Test
	public void testLeftRotation() {
		// SmallCar Test:
		assertEquals(0 , smallCar.getAlpha());
		assertEquals("North", smallCar.getDirection());
		
		smallCar.turnLeft();
		assertEquals(90 , smallCar.getAlpha());
		assertEquals("West", smallCar.getDirection());
		
		smallCar.turnLeft();
		assertEquals(180 , smallCar.getAlpha());
		assertEquals("South", smallCar.getDirection());
		
		smallCar.turnLeft();
		assertEquals(270 , smallCar.getAlpha());
		assertEquals("East", smallCar.getDirection());
		
		// Truck Test:
		assertEquals(0 , truck.getAlpha());
		assertEquals("North", truck.getDirection());
		
		truck.turnLeft();
		assertEquals(90 , truck.getAlpha());
		assertEquals("West", truck.getDirection());
		
		truck.turnLeft();
		assertEquals(180 , truck.getAlpha());
		assertEquals("South", truck.getDirection());
		
		truck.turnLeft();
		assertEquals(270 , truck.getAlpha());
		assertEquals("East", truck.getDirection());
		
		
		// Limo Test:
		assertEquals(0 , limo.getAlpha());
		assertEquals("North", limo.getDirection());
		
		limo.turnLeft();
		assertEquals(90 , limo.getAlpha());
		assertEquals("West", limo.getDirection());
		
		limo.turnLeft();
		assertEquals(180 , limo.getAlpha());
		assertEquals("South", limo.getDirection());
		
		limo.turnLeft();
		assertEquals(270 , limo.getAlpha());
		assertEquals("East", limo.getDirection());
	}
	
	@Test
	public void testRightRotation() {
		// SmallCar Test:
		assertEquals(0 , smallCar.getAlpha());
		assertEquals("North", smallCar.getDirection());
		
		smallCar.turnRight();
		assertEquals(270 , smallCar.getAlpha());
		assertEquals("East", smallCar.getDirection());
		
		smallCar.turnRight();
		assertEquals(180 , smallCar.getAlpha());
		assertEquals("South", smallCar.getDirection());
		
		smallCar.turnRight();
		assertEquals(90 , smallCar.getAlpha());
		assertEquals("West", smallCar.getDirection());
		
		// Truck Test:
		assertEquals(0 , truck.getAlpha());
		assertEquals("North", truck.getDirection());
		
		truck.turnRight();
		assertEquals(270 , truck.getAlpha());
		assertEquals("East", truck.getDirection());
		
		truck.turnRight();
		assertEquals(180 , truck.getAlpha());
		assertEquals("South", truck.getDirection());
		
		truck.turnRight();
		assertEquals(90 , truck.getAlpha());
		assertEquals("West", truck.getDirection());
		
		
		// Limo Test:
		assertEquals(0 , limo.getAlpha());
		assertEquals("North", limo.getDirection());
		
		limo.turnRight();
		assertEquals(270 , limo.getAlpha());
		assertEquals("East", limo.getDirection());
		
		limo.turnRight();
		assertEquals(180 , limo.getAlpha());
		assertEquals("South", limo.getDirection());
		
		limo.turnRight();
		assertEquals(90 , limo.getAlpha());
		assertEquals("West", limo.getDirection());
	}
	
	@Test
	public void testForward() {
		// SmallCar Test:
		assertEquals("North", smallCar.getDirection());
		assertEquals(new Point(2,2), smallCar.getPosition());
		
		smallCar.forward();
		assertEquals(new Point(2,3), smallCar.getPosition());
		
		smallCar.turnLeft();
		smallCar.forward();
		assertEquals(new Point(1,3), smallCar.getPosition());
		
		smallCar.turnLeft();
		smallCar.forward();
		assertEquals(new Point(1,2), smallCar.getPosition());
		
		smallCar.turnLeft();
		smallCar.forward();
		assertEquals(new Point(2,2), smallCar.getPosition());
		
		// Truck Test:
		assertEquals("North", truck.getDirection());
		assertEquals(new Point(2,2), truck.getPosition());
		
		truck.forward();
		assertEquals(new Point(2,3), truck.getPosition());
		
		truck.turnLeft();
		truck.forward();
		assertEquals(new Point(1,2), truck.getPosition());
		
		truck.turnLeft();
		truck.forward();
		assertEquals(new Point(2,1), truck.getPosition());
		
		truck.turnLeft();
		truck.forward();
		assertEquals(new Point(3,2), truck.getPosition());
		
		// SmallCar Test:
		assertEquals("North", limo.getDirection());
		assertEquals(new Point(2,2), limo.getPosition());
		
		limo.forward();
		assertEquals(new Point(2,3), limo.getPosition());
		
		limo.turnLeft();
		limo.forward();
		assertEquals(new Point(0,3), limo.getPosition());
		
		limo.turnLeft();
		limo.forward();
		assertEquals(new Point(0,1), limo.getPosition());
		
		limo.turnLeft();
		limo.forward();
		assertEquals(new Point(2,1), limo.getPosition());
	}
	
	@Test
	public void testBackward() {
		// SmallCar Test:
		assertEquals("North", smallCar.getDirection());
		assertEquals(new Point(2,2), smallCar.getPosition());
		
		smallCar.backward();
		assertEquals(new Point(2,1), smallCar.getPosition());
		
		smallCar.turnLeft();
		smallCar.backward();
		assertEquals(new Point(3,1), smallCar.getPosition());
		
		smallCar.turnLeft();
		smallCar.backward();
		assertEquals(new Point(3,2), smallCar.getPosition());
		
		smallCar.turnLeft();
		smallCar.backward();
		assertEquals(new Point(2,2), smallCar.getPosition());
		
		// Truck Test:
		assertEquals("North", truck.getDirection());
		assertEquals(new Point(2,2), truck.getPosition());
		
		truck.backward();
		assertEquals(new Point(2,1), truck.getPosition());
		
		truck.turnLeft();
		truck.backward();
		assertEquals(new Point(3,0), truck.getPosition());
		
		truck.turnLeft();
		truck.backward();
		assertEquals(new Point(4,1), truck.getPosition());
		
		truck.turnLeft();
		truck.backward();
		assertEquals(new Point(3,2), truck.getPosition());
		
		// Limo Test:
		assertEquals("North", limo.getDirection());
		assertEquals(new Point(2,2), limo.getPosition());
		
		limo.backward();
		assertEquals(new Point(2,1), limo.getPosition());
		
		limo.turnLeft();
		limo.backward();
		assertEquals(new Point(2,1), limo.getPosition());
		
		limo.turnLeft();
		limo.backward();
		assertEquals(new Point(2,1), limo.getPosition());
		
		limo.turnLeft();
		limo.backward();
		assertEquals(new Point(2,1), limo.getPosition());
	}
	
	@Test
	public void testSetPosition() {
		// SmallCar Test:
		assertEquals("North", smallCar.getDirection());
		assertEquals(new Point(2,2), smallCar.getPosition());
		
		smallCar.setPosition(new Point(4,4));
		assertEquals(new Point(4,4), smallCar.getPosition());
		
		// Truck Test:
		assertEquals("North", truck.getDirection());
		assertEquals(new Point(2,2), truck.getPosition());
		
		truck.setPosition(new Point(4,4));
		assertEquals(new Point(4,4), truck.getPosition());
		
		// Limo Test:
		assertEquals("North", limo.getDirection());
		assertEquals(new Point(2,2), limo.getPosition());
		
		limo.setPosition(new Point(4,4));
		assertEquals(new Point(4,4), limo.getPosition());
	}
	
	@Test
	public void testCarInsideRoom() {
		// SmallCar Test:
		assertTrue(smallCar.carInside(5, 5));
		
		smallCar.setPosition(new Point(6,4));
		assertFalse(smallCar.carInside(5, 5));
		
		smallCar.setPosition(new Point(4,6));
		assertFalse(smallCar.carInside(5, 5));
		
		smallCar.setPosition(new Point(-1,4));
		assertFalse(smallCar.carInside(5, 5));
		
		smallCar.setPosition(new Point(4,-1));
		assertFalse(smallCar.carInside(5, 5));
		
		// Truck Test:
		assertTrue(truck.carInside(5, 5));
		
		truck.setPosition(new Point(5,4));
		assertFalse(truck.carInside(5, 5));
		
		truck.setPosition(new Point(4,5));
		assertFalse(truck.carInside(5, 5));
		
		truck.setPosition(new Point(-1,4));
		assertFalse(truck.carInside(5, 5));
		
		truck.setPosition(new Point(4,-1));
		assertFalse(truck.carInside(5, 5));
		
		// Limo Test:
		assertTrue(limo.carInside(5, 5));
		
		limo.setPosition(new Point(6,4));
		assertFalse(limo.carInside(5, 5));
		
		limo.setPosition(new Point(4,6));
		assertFalse(limo.carInside(5, 5));
		
		limo.setPosition(new Point(-1,4));
		assertFalse(limo.carInside(5, 5));
		
		limo.setPosition(new Point(4,-1));
		assertFalse(limo.carInside(5, 5));
	}
}
