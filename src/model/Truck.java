package model;

import java.awt.Point;

/**
 * Implements a Truck that can move around
 * */
public class Truck extends Car {
	
	/**
	 * constructs a Truck having initial position and initial direction
	 * @param position initial position of the Truck
	 * @param direction initial direction of the Truck((East,North,West,South))
	 */
	public Truck(Point position, String direction) {
		super(position, direction);
	}
	
	/**
	 *  stores drivers current position's coordinate(front-left point ),
	 *  back-left, front-right  ,back-right of the truck
     *  and returns all the  points
     * @return the current four points of the car according to the angle
	 */
	 @Override
	public Point[]  getCoordinates() {
		Point[] coordinateArray = new Point[4];
		int alpha = getAlpha() % 360;
		switch (alpha) {
			case 0: {
				coordinateArray[0] = getPosition();
				coordinateArray[1] = new Point(getPosition().x, getPosition().y-1);
				coordinateArray[2] = new Point(getPosition().x+1, getPosition().y);
				coordinateArray[3] = new Point(getPosition().x+1, getPosition().y-1);
				break;
			}
			case 90: {
				coordinateArray[0] = getPosition();
				coordinateArray[1] = new Point(getPosition().x+1, getPosition().y);
				coordinateArray[2] = new Point(getPosition().x, getPosition().y+1); 
				coordinateArray[3] = new Point(getPosition().x+1, getPosition().y+1);
				break;
			}			
			case 180: {
				coordinateArray[0] = getPosition();
				coordinateArray[1] = new Point(getPosition().x, getPosition().y+1);
				coordinateArray[2] = new Point(getPosition().x-1, getPosition().y); 
				coordinateArray[3] = new Point(getPosition().x-1, getPosition().y+1);
				break;
			}
			case 270: {
				coordinateArray[0] = getPosition();
				coordinateArray[1] = new Point(getPosition().x-1, getPosition().y);
				coordinateArray[2] = new Point(getPosition().x, getPosition().y-1);                               
				coordinateArray[3] = new Point(getPosition().x-1, getPosition().y-1);
				break;
			}
			default:
				System.out.println("The angle is not 0, 90, 180 or 270.");
				break;
		}
		return coordinateArray;		
	}

	/**
	 * turns the truck to 90 degree left 
	 * and sets the driver's position according the angle
	 */
	 @Override
	public void turnLeft() {
		int alpha = getAlpha() % 360;
		switch (alpha) {
			case 0: {
				setPosition(new Point(getPosition().x , getPosition().y-1));
				break;
			}
			case 90: {
				setPosition(new Point(getPosition().x+1 , getPosition().y));
				break;
			}
			
			case 180: {
				setPosition(new Point(getPosition().x , getPosition().y+1));
				break;
			}
			case 270: {
				setPosition(new Point(getPosition().x-1 , getPosition().y));
				break;
			}
			default:
				System.out.println("The angle is not 0, 90, 180 or 270.");
				break;
		}
		setAlpha(alpha+90);
	}
	
	/**
	 * turns the truck to the 90 degree right 
	 *  and sets the driver's position according the angle
	 */
	 @Override
	public void turnRight() {
		int alpha = getAlpha() % 360;
		switch (alpha) {
			case 0: {
				setPosition(new Point(getPosition().x+1 , getPosition().y));
				break;
			}
			case 90: {
				setPosition(new Point(getPosition().x , getPosition().y+1));
				break;
			}
			case 180: {
				setPosition(new Point(getPosition().x-1 , getPosition().y));
				break;
			}
			case 270: {
				setPosition(new Point(getPosition().x , getPosition().y-1));
				break;
			}
		}
		int newAlpha = alpha-90;
		if (newAlpha < 0) {
			newAlpha = 270;
		}
		setAlpha(newAlpha);
	}

	/**
	 * Check if all parts of the the Truck is inside the room.
     * @param room_width is the width of the room.
     * @param room_length is the length of the room.
	 */
	 @Override
	public boolean carInside(int room_width,int room_length) {
		Point[] coordinates = getCoordinates();		
		return !(crashed(coordinates[0], room_width, room_length) || crashed(coordinates[1], room_width, room_length) ||
				crashed(coordinates[2], room_width, room_length) || crashed(coordinates[3], room_width, room_length));
	}
	
	/**
	 * checks if all the parts(front-left,back-left,front-right,back-right)
	 *  of the Truck are inside the room
	 * @param position the  position of each part of the truck
	 * @param room_width  is the width of the room.
	 * @param room_length is the length of the room.
	 */
	private boolean crashed(Point position, int room_width,int room_length) {
		 return (position.getX() <0) || (position.getX() >= room_length) ||(position.getY() < 0) || (position.getY() >= room_width ); 
	}
}
