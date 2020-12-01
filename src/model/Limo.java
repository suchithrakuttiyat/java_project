package model;

import java.awt.Point;

/**implements Limo that can move around*/
public class Limo extends Car{
	
	/**
	 * constructs a Limo having initial position and initial direction
	 * @param position initial position of the Limo
	 * @param direction initial direction of the Limo((East,North,West,South))
	 */
	public Limo(Point position, String direction) {
		super(position, direction);
	}

	/**
	 * turns the truck to the left at an angle of 90 degree
	 * and sets the driver's position(front left) according the angle
	 */
	@Override
	public void turnLeft() {
		int alpha = getAlpha() % 360;
		switch (alpha) {
			case 0: {
				setPosition(new Point(getPosition().x-1 , getPosition().y));
				break;
			}
			case 90: {
				setPosition(new Point(getPosition().x , getPosition().y-1));
				break;
			}
			
			case 180: {
				setPosition(new Point(getPosition().x+1 , getPosition().y));
				break;
			}
			case 270: {
				setPosition(new Point(getPosition().x , getPosition().y+1));
				break;
			}
			default:
				System.out.println("The angle is not 0, 90, 180 or 270.");
				break;
		}
		setAlpha(alpha+90);
	}

	/**
	 * turns the truck to the right at an angle of 90 degree
	 * and sets the driver's position according the angle
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
			default:
				System.out.println("The angle is not 0, 90, 180 or 270.");
				break;
		}
		int newAlpha = alpha-90;
		if (newAlpha < 0) {
			newAlpha = 270;
		}
		setAlpha(newAlpha);
	}
    
	/**
	 *  stores drivers current position's coordinate(front)& back,
     *  and returns front and back  points
     * @return the current four points of the car according to the angle
	 */
	@Override
	public Point[] getCoordinates() {
		Point[] coordinateArray = new Point[2];
		int alpha = getAlpha() % 360;
		switch (alpha) {
			case 0: {
				coordinateArray[0] = getPosition();
				coordinateArray[1] = new Point(getPosition().x, getPosition().y-1);
				break;
			}
			case 90: {
				coordinateArray[0] = getPosition();
				coordinateArray[1] = new Point(getPosition().x+1, getPosition().y);
				break;
			}
			
			case 180: {
				coordinateArray[0] = getPosition();
				coordinateArray[1] = new Point(getPosition().x, getPosition().y+1);
				break;
			}
			case 270: {
				coordinateArray[0] = getPosition();
				coordinateArray[1] = new Point(getPosition().x-1, getPosition().y);
				break;
			}
			default:
				System.out.println("The angle is not 0, 90, 180 or 270.");
				break;
		}
		return coordinateArray;	
	}
    
	/**
	 * Check if all parts of the the Limo is inside the room.
     * @param room_width is the width of the room.
     * @param room_length is the length of the room.
	 */
	@Override
	public boolean carInside(int room_width, int room_length) {
		Point[] coordinates = getCoordinates();		
		return !(crashed(coordinates[0], room_width, room_length) || crashed(coordinates[1], room_width, room_length));
	}
	
	/**
	 * checks the two parts(front,back)
	 *  of the Limo are inside the room
	 * @param position the  position of each part of the tLimo
	 * @param room_width  is the width of the room.
	 * @param room_length is the length of the room.
	 */
	private boolean crashed(Point position, int room_width,int room_length) {
		 return (position.getX() <0) || (position.getX() >= room_length) ||(position.getY() < 0) || (position.getY() >= room_width ); 
	}

}
