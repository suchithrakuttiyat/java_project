package model;

import java.awt.Point;

/**
 * implements car that can move around
 * */
 
public abstract class Car {
	
	private Point position; 
	private int alpha;
	private String direction;
	private final int step = 1;
	
	/**
	 * constructs a car having a initial position and initial direction
	 * @param position initial position of the car
	 * @param direction initial direction of the car(East,North,West,South)
	 */
	public Car(Point position,String direction) {
		this.position = position;
		this.direction = direction;
		
		switch(direction) {
	        case "East"  : {alpha=270;   break; }
	        case "South" : {alpha=180; break; }
	        case "West"  : {alpha=90; break; }
	        case "North" : {alpha=0;  break; }
	    } 
	}
	
	/**
	 * moves the car forward 
	 * @param step  length of one movement
	 */
    public  void forward() {
    	getPosition().x = getPosition().x - (int)Math.round((step*(Math.sin(Math.toRadians(getAlpha())))));
    	getPosition().y = getPosition().y + (int)Math.round((step*(Math.cos(Math.toRadians(getAlpha())))));
    } 
    
    /**
     * moves the car backward 
     * @param step  length of one movement
    */
    public  void backward() {
    	getPosition().x = getPosition().x + (int)Math.round((step*(Math.sin(Math.toRadians(getAlpha())))));
    	getPosition().y = getPosition().y - (int)Math.round((step*(Math.cos(Math.toRadians(getAlpha())))));
    } 
    
    /**
     * returns the  direction
     * @return the direction
    */
	public String getDirection(){
		switch(alpha) {
	        case  0 : {direction= "North";   break; }
	        case 90 : {direction= "West"; break; }
	        case 180: {direction= "South"; break; }
	        case 270: {direction= "East";  break; }
	    } 
		return direction;
	}
	
	/**
	 * returns the current  angle of direction
	 * @return the angle
	*/
    public int getAlpha() {
		return alpha;
	}
    
    /**
     * sets the current angle after movement 
     * @param Alphanew  the current angle
     */  
    public void setAlpha(int Alphanew){
    	alpha=Alphanew;
    }
    
    /** 
     * returns the current position 
     * @return the current position's coordinate
     */     
    public Point getPosition(){
    	return position;
    }
    
    /**
     * sets the new position after movement
     * @param point the current position's coordinate
     */
    public void setPosition(Point point) {
    	position = point;
    }
    
    /**
     * turns the car 90 degree left 
     * */
    public abstract void turnLeft(); 
    
    /**
     * turns the car 90 degree right 
     * */
    public abstract void turnRight();
    
    /**
     * returns the  current position
     * @return the  current position coordinates
     */
    public abstract Point[]  getCoordinates();
   
    /**
     * Check if all parts of the the car is inside the room.
     * @param room_width is the width of the room.
     * @param room_length is the length of the room.
     */
    public abstract boolean carInside(int room_width,int room_length);  	
}
