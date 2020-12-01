package model;

import java.awt.Point;

/**implements a SmallCar which can move around*/
public class SmallCar extends Car{

	/**
	 * constructs a SmallCar having initial a position 
	 * and initial direction
	 * @param position initial position
	 * @param direction initial direction of the SmallCar(((East,North,West,South))
	 */
	public SmallCar(Point position,String direction) {
		super( position, direction);
	}
	
    /**
     * turns the car to  90 degree left and sets
     * the new angle
     */
	 @Override
    public  void turnLeft() {
		int alpha = getAlpha() % 360;
    	setAlpha(alpha+90);
    }
    
    /**
     * turns the car to 90 degree right and sets
     * the new angle
     */
    @Override
    public  void turnRight() {
		int alpha = getAlpha() % 360;
		int newAlpha = alpha-90;
		if (newAlpha < 0) {
			newAlpha = 270;
		}
		setAlpha(newAlpha);
    }
    
    /**
     * stores the driver's current position coordinate 
     * and returns that coordinate
     * @return the current position coordinate 
     */
    @Override
    public Point[]  getCoordinates() {
    	Point[] coordinates =  new Point[1];
    	coordinates[0] = getPosition();
    	return coordinates;
    }  
    
    /**
     * Check if  the the car is inside the room.
     * @param room_width is the width of the room.
     * @param room_length is the length of the room.
     */
    @Override
    public  boolean carInside(int room_width,int room_length) {	
    	return (getPosition().x >= 0) && (getPosition().x < room_length) && (getPosition().y >= 0) && (getPosition().y < room_width );
    }
}
