
Radio Controlled Car Simulator :

	Provide a simulator for radio controlled cars with a JavaFX GUI where the user interacts with the simulator,
	by choosing a room for a car to move in, where the room is considered to be surrounded by walls.
	The user can choose a radio car from a selection and choose start position and direction for the car and if the 
	position is inside the room the user can write the action commands or use a keyboard to move the car.
	The simulator handles various commands to make the car move and the results will be based on the commands that 
	the user has put and shows if the route is successful or not according to given commands.
	Successful while not crashing into any wall during the route showing of the end position of the car as well as the heading of it.
	A unsuccessful result appear when car crash into a wall, the program stops execution and 
	it shows“ Unsuccessful ”  massage , describe an error of what went wrong.


The Room :

	The room dimension represents the whole meters and has no decimals. represent by two integers X, Y.
	The simulator has two slides to provide those integers as a room dimension to provide a rectangular-shaped room.  
	"Length" and  "Width" with minimum value 2 meters for each( to be sure  Monster_Truck or Limo can fit there ).
	The default values for X, Y is 20 meters and a maximum of 100 meters.
	The room is considered to be surrounded by walls.


The Car :
		
	-The Small_Car has a size of a 1x1 meter.	
	-The Monster_Truck has a size of a 2x2 meter.	
	-The Limo can have a size of a 1x2 meter.
	
	The user can choose a car from the drop list in simulator GUI under the label "Select a car ".
	The car has a heading direction.
	A car can move forward, move backward, also turn left and turn right. 
	Move either forward or backward is one-meter step while a turn to either the left or the right is a 90-degree turn.
 
 
The Car starting position and heading:

	 A car can have start position  X, Y  as an integer and heading direction; North, west, south or east, 
	 represented by input commands, the user can choose them from drop list as North, West, South or East.
	 If the user chooses the wrong starting position for small car or unacceptable position for Monster_Tertruck or Limowher ( part of the car is outside of the room),
     the simulator detects an incorrect starting position and an error message is shown asking the user to provide a new appropriate car starting position.


A sequence of action commands:

	The user can write input commands in the " Action command(s) " text field  as F, B, L and R respectively (Ex. FLBBRL).
	The car moves and turns according to command(s) input, it can't move through a wall.
	A car can move forward, move backward, also turn left and turn right. 
	A move either forward or backward is a one-meter step.
	A turn to either the left or the right is a 90-degree turn. 

 
The Graphical User Interface GUI :

	The simulation GUI is a one-window interface, has two main parts right side repersents the room where the car can move in, the left part where the user can choose 
	room dimension, car selection, starting position and heading.
	then the user can provide the simulator with a sequence of action commands. 
	The user running the simulating after submitting the inputs by clicking the "Start" button.
	The simulator shows the results based on given commands input.
	The results shown in "Result" textfeild as ethier  " Successfull :Car Postion :  X:x   Y:y   " when the choosen path not crashing into any wall during the route .
	or  "Unsuccessfull :  Car crashed at position : X:x Y:y "  when  car crash into a wall.      
	Both x and  y are integers.
 
	The graphic of represnt the chossen car will appear in the room showing the whole path.
	The defoult appernace for the room is grid where the user can disable it from top mnue "Setting" by chossing "Grid"


	After a simulation has run, it shows output result in the lable called "Result"
	as " Successfull :Car Postion :  X:x   Y:y   "  or  "Unsuccessfull :  Car crashed at position : X:x Y:y "        
	where  x, y are integers.
	
	The user can move and turn car one step each time by choosing the "Use keyboard (W, S, A, D)" checkbox 
    represent as input commands move forward, move backward, turn left and turn right respectively.