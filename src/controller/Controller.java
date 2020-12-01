package controller;

import java.awt.Point;

import model.Car;
import model.Limo;
import model.SmallCar;
import model.Truck;

/**
 * Controller is the bridge between Model and View.
*/
public class Controller {
	
	Car car;
	
	/**
	 * Create a Car with specific "carType".
	 * @param carType is the type of the car.
	 * @param carPos is the position of the car.
	 * @param direction is the direction of the car.
	 */
	public Controller(String carType, Point carPos, String direction) {
	
		switch (carType) {
		case "Car":
			car = new SmallCar(carPos, direction);
			break;
		case "MonsterTruck":
			car = new Truck(carPos, direction);
			break;
		case "Limo":
			car = new Limo(carPos, direction);
			break;

		default:
			throw new IllegalArgumentException("The car does not exist!");
		}
	}
	
	/**
	 * Get the direction of the car.
	 * @return Integer
	 */
	public int getDirection() {
		return car.getAlpha();
	}
	
	/**
	 * Get the position of the car.
	 * @return Point(x,y).
	 */
	public Point getPosition() {
		return car.getPosition();
	}
	
	/**
	 * Check if all parts of the car is inside the room or not.
	 * @param width of the room.
	 * @param length of the room.
	 * @return true or false.
	 */
	public boolean carInside(int width, int length) {
		return car.carInside(width, length);
	}
	
	/**
	 * Get position of the car.
	 * @return Point(x,y).
	 */
	public Point[] getCoordinates() {	
		return car.getCoordinates();
	}
	
	/**
	 * Move the car according the command.
	 * @param command is the command that user enters.
	 * @return the position of the car after movement.
	 */
	public Point moveCar(Character command) {
		switch (Character.toLowerCase(command)) {
			case 'f':
				car.forward();
				break;
			case 'b':
				car.backward();
				break;
			case 'l':
				car.turnLeft();
				break;
			case 'r':
				car.turnRight();
				break;
			default:
				throw new IllegalArgumentException("The command should be 'F , B, R or L'.");
			}		
		return car.getPosition();
	}
}
