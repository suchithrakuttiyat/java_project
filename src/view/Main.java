package view;

import java.awt.Point;
import java.io.File;

import controller.Controller;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

	private final double roomPanelSize = 700.;
	private BorderPane root;
	private Controller car;
	private boolean haveGrid = true;
	private Slider widthSlider;
	private Slider lengthSlider;
	private Pane[][] boxes;

	Stage stage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		this.stage = stage;
		stage.setTitle("Radio Controled Car Simulation");
		root = new BorderPane();

		root.setTop(menu());
		root.setLeft(form());
		root.setCenter(room(20, 20));

		stage.setScene(new Scene(root));
		stage.setResizable(false);

		stage.show();
	}

	/**
	 * This method create a from at left side of pane to get information from user.
	 * @return VBox
	 */
	private Parent form() {
		
		VBox form = new VBox();
		form.setPrefSize(500, 700);
		form.setPadding(new Insets(25, 25, 25, 25));
		
		Text dimensionsLbl = new Text("Write prefered room size in meter:");
		dimensionsLbl.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));

		/**
		 * Width Hbox
		 */
		HBox widthSize = new HBox();
		widthSize.setAlignment(Pos.CENTER_LEFT);

		Label widthLbl = new Label("Width:");
		widthLbl.setFont(Font.font("Times New Roman", 18));
		widthLbl.setPadding(new Insets(0, 5, 0, 0));

		widthSlider = new Slider(2, 100, 20);
		widthSlider.setMajorTickUnit(10.0);
		widthSlider.setShowTickMarks(true);
		widthSlider.setPadding(new Insets(20, 10, 0, 10));
		widthSlider.setPrefWidth(305);
		widthSlider.setShowTickLabels(true);

		Label widthNr = new Label();
		widthNr.setPrefSize(60, 20);
		widthNr.setText((int) widthSlider.getValue() + "");
		widthNr.setStyle("-fx-background-color: white;");
		widthNr.setAlignment(Pos.CENTER);

		widthSize.getChildren().addAll(widthLbl, widthSlider, widthNr);

		/**
		 * Length HBox
		 */
		HBox lengthSize = new HBox();
		lengthSize.setAlignment(Pos.CENTER_LEFT);

		Label lengthLbl = new Label("Length:");
		lengthLbl.setFont(Font.font("Times New Roman", 18));

		lengthSlider = new Slider(2, 100, 20);
		lengthSlider.setMajorTickUnit(10.0);
		lengthSlider.setShowTickMarks(true);
		lengthSlider.setPrefWidth(300);
		lengthSlider.setShowTickLabels(true);
		lengthSlider.setPadding(new Insets(20, 10, 0, 5));

		Label lengthNr = new Label();
		lengthNr.setText((int) lengthSlider.getValue() + "");
		lengthNr.setPrefSize(60, 20);
		lengthNr.setStyle("-fx-background-color: white;");
		lengthNr.setAlignment(Pos.CENTER);

		lengthSize.getChildren().addAll(lengthLbl, lengthSlider, lengthNr);

		/**
		 * Selecting the car.
		 */
		Label selectLbl = new Label("Select a car:");
		selectLbl.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
		selectLbl.setPadding(new Insets(20, 0, 5, 0));

		VBox selectCar = new VBox();
		selectCar.setPrefSize(100, 120);
		// Select a car:
		ComboBox<String> cars = new ComboBox<String>();
		// Set the CellFactory property
		cars.setCellFactory(arg -> new imageCell());
		// Set the ButtonCell property
		cars.setButtonCell(new imageCell());
		cars.resize(100, 100);
		cars.getItems().addAll("Car", "MonsterTruck", "Limo");
		cars.setOnAction(e -> {
		});
		cars.setValue("Car");
		selectCar.getChildren().add(cars);

		/**
		 * Selecting the car position.
		 */
		Label selectPositionLbl = new Label("Select initial car direction and position:");
		selectPositionLbl.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));

		HBox carPosition = new HBox();
		carPosition.setAlignment(Pos.TOP_CENTER);
		carPosition.setPadding(new Insets(10, 0, 0, 0));
		ComboBox<String> directions = new ComboBox<String>();
		String[] directionsArray = { "North", "South", "East", "West" };
		directions.getItems().addAll(directionsArray);
		directions.setPrefSize(85, 20);
		directions.setValue("North");

		Label xLbl = new Label("X:");
		xLbl.setFont(Font.font("Times New Roman", 18));
		xLbl.setPadding(new Insets(3, 5, 0, 20));

		ConditionalTextField xNr = new ConditionalTextField("[0-9]", 3);
		xNr.setPrefSize(60, 20);
		xNr.setText("3");

		Label yLbl = new Label("Y:");
		yLbl.setFont(Font.font("Times New Roman", 18));
		yLbl.setPadding(new Insets(3, 5, 0, 20));

		ConditionalTextField yNr = new ConditionalTextField("[0-9]", 3);
		yNr.setPrefSize(60, 20);
		yNr.setText("5");

		carPosition.getChildren().addAll(directions, xLbl, xNr, yLbl, yNr);

		/**
		 * Submit and reset button
		 */
		HBox submit = new HBox();
		submit.setSpacing(20);
		submit.setAlignment(Pos.CENTER);
		submit.setPadding(new Insets(20, 0, 5, 0));

		Button submitBtn = new Button("Submit");
		Button resetBtn = new Button("Reset");

		submit.getChildren().addAll(submitBtn, resetBtn);

		/**
		 * selecting sequence of action commands.
		 */
		CheckBox usingKeyboard = new CheckBox("Use Keyboard(W, S, A, D)");
		usingKeyboard.setSelected(false);
		usingKeyboard.setDisable(true);

		HBox commands = new HBox();

		Label commandsLbl = new Label("Action command(s): ");
		commandsLbl.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
		commandsLbl.setPadding(new Insets(20, 0, 5, 0));

		ConditionalTextField commandTxt = new ConditionalTextField("[F,f,B,b,R,r,L,l]", 20);
		commandTxt.setDisable(true);

		commands.getChildren().addAll();

		/**
		 * Showing the result.
		 */

		Label resultLbl = new Label("Result:");
		resultLbl.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
		resultLbl.setPadding(new Insets(20, 0, 5, 0));
		Label finalResultLbl = new Label("");
		finalResultLbl.setFont(Font.font("Times New Roman", 18));

		/**
		 * Start Button.
		 */
		HBox start = new HBox();
		start.setPadding(new Insets(50, 0, 5, 0));
		start.setAlignment(Pos.BOTTOM_CENTER);
		Button startBtn = new Button("Start");
		startBtn.setDisable(true);
		startBtn.setPrefSize(100, 50);
		startBtn.setFont(Font.font("Times New Roman", 18));
		
		start.getChildren().add(startBtn);

		/**
		 * Events
		 */
		widthSlider.valueProperty().addListener(e -> {
			widthNr.setText((int) widthSlider.getValue() + "");
		});

		lengthSlider.valueProperty().addListener(e -> {
			lengthNr.setText((int) lengthSlider.getValue() + "");
		});

		submitBtn.setOnAction(e -> {
			int width = (int) widthSlider.getValue();
			int length = (int) lengthSlider.getValue();
			usingKeyboard.setSelected(false);
			usingKeyboard.setDisable(true);
			if (!xNr.getText().isEmpty() && !yNr.getText().isEmpty()) {
				Point carPos = new Point(Integer.parseInt(xNr.getText()), Integer.parseInt(yNr.getText()));
				String direction = directions.getValue();

				car = new Controller(cars.getValue(), carPos, direction);
				root.setCenter(room((int) width, (int) length));
				if (car.carInside(width, length)) {
					commandTxt.setDisable(false);
					startBtn.setDisable(false);
					usingKeyboard.setDisable(false);
					submitBtn.setDisable(true);
					lengthSlider.setDisable(true);
					widthSlider.setDisable(true);
					directions.setDisable(true);
					cars.setDisable(true);
					xNr.setDisable(true);
					yNr.setDisable(true);
					drawCar(cars.getValue());
				} else {
					showErrorAlert("Car or Part of the car is outside of the room!!");
				}
			}
		});

		resetBtn.setOnAction(e -> {
			commandTxt.setDisable(true);
			startBtn.setDisable(true);
			commandTxt.setDisable(true);
			usingKeyboard.setDisable(true);
			submitBtn.setDisable(false);
			lengthSlider.setDisable(false);
			widthSlider.setDisable(false);
			directions.setDisable(false);
			cars.setDisable(false);
			xNr.setDisable(false);
			yNr.setDisable(false);
		});
		
		usingKeyboard.setOnAction(e -> {
			if (usingKeyboard.isSelected()) {
				commandTxt.setDisable(true);
				startBtn.setDisable(true);
			} else {
				commandTxt.setDisable(false);
				startBtn.setDisable(false);
			}
		});
		
		startBtn.setOnAction(e -> {
			commandTxt.setDisable(true);
			usingKeyboard.setDisable(true);
			String movements = commandTxt.getText();
			startBtn.setDisable(true);
			
			for (int i = 0; i < movements.length(); i++) {
				car.moveCar(movements.charAt(i));
				if (car.carInside((int) widthSlider.getValue(), (int) lengthSlider.getValue())) {
					drawCar(cars.getValue());
				} else {
					System.out.println("Crashed!!");
					finalResultLbl.setText("Car crashed at position x: " + (int)car.getPosition().getX() + ", y: " + (int)car.getPosition().getY());
					showErrorAlert("Car crashed at position x: " + (int)car.getPosition().getX() + ", y: " + (int)car.getPosition().getY());
					return;
				}
			}
			finalResultLbl.setText("Successfull: Car position x: " + (int)car.getPosition().getX() + ", y: " +(int) car.getPosition().getY());
		});
		
		form.setOnKeyPressed( e -> {
			if (usingKeyboard.isSelected()) {
				if (e.getCode().equals(KeyCode.W)) {
					car.moveCar('f');
				} else if (e.getCode().equals(KeyCode.S)) {
					car.moveCar('b');
				} else if (e.getCode().equals(KeyCode.D)) {
					car.moveCar('r');
				} else if (e.getCode().equals(KeyCode.A)) {
					car.moveCar('l');
				}
				if (car.carInside((int) widthSlider.getValue(), (int) lengthSlider.getValue())) {
					drawCar(cars.getValue());
					finalResultLbl.setText("Successfull: Car position x: " + (int)car.getPosition().getX() + ", y: " + (int)car.getPosition().getY());
				} else {
					System.out.println("Crashed!!");
					finalResultLbl.setText("Car crashed at position x: " + (int)car.getPosition().getX() + ", y: " + (int)car.getPosition().getY());
					showErrorAlert("Car crashed at position x: " + (int)car.getPosition().getX() + ", y: " + (int)car.getPosition().getY());
					usingKeyboard.setSelected(false);
					usingKeyboard.setDisable(true);
					return;
				}
			}
		});
				
		form.getChildren().addAll(dimensionsLbl,  lengthSize, widthSize, selectLbl, selectCar, selectPositionLbl,
				carPosition, submit, usingKeyboard, commandsLbl, commandTxt, resultLbl, finalResultLbl, start);

		return form;
	}

	/**
	 * Place car image at the room panel.
	 * @param carType is type of the car
	 */
	private void drawCar(String carType) {
		Point[] cordinates = car.getCoordinates();
		for (int i = 0; i < cordinates.length; i++) {
			Image image = new Image(new File("res/pictures/" + carType + i + ".jpg").toURI().toString());
			ImageView imageView = new ImageView(image);
			imageView.fitWidthProperty().bind(boxes[0][0].widthProperty());
			imageView.fitHeightProperty().bind(boxes[0][0].heightProperty());

			boxes[(int) cordinates[i].getX()][(int) widthSlider.getValue() - (int) cordinates[i].getY() -1].getChildren().add(imageView);

			imageView.setRotate(-car.getDirection());
		}
	}	

	/**
	 * Create a room panel to place 
	 * @return room panel where the car can move inside.
	 */
	private Parent room(int width, int length) {

		GridPane room = new GridPane();
		room.setBorder(new Border(new BorderStroke(Color.DARKBLUE, BorderStrokeStyle.DOTTED,
				CornerRadii.EMPTY, new BorderWidths(2))));

		room.setPrefSize(roomPanelSize, roomPanelSize);
		room.setStyle("-fx-background-color: gray;");
		boxes = new Pane[length][width];

		for (int y = 0; y < width; y++) {
			for (int x = 0; x < length; x++) {

				boxes[x][y] = new Pane();
				boxes[x][y].setPrefSize(roomPanelSize / length, roomPanelSize / width);
				boxes[x][y].setStyle("-fx-background-color: white;");

				if (haveGrid) {
					boxes[x][y].setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
							CornerRadii.EMPTY, BorderWidths.DEFAULT)));
				}
				
				room.add(boxes[x][y], x, y, 1, 1);
			}
		}
		return room;
	}

	/**
	 * Create Setting menu to add/remove grid to the room panel.
	 * @return MenuBar
	 */
	private MenuBar menu() {
		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("Setting");

		CheckMenuItem grid = new CheckMenuItem("Grid");
		grid.setSelected(true);
		grid.setOnAction(e -> {
			haveGrid = grid.isSelected();
			root.setCenter(room((int) widthSlider.getValue(), (int) lengthSlider.getValue()));
		});

		menu.getItems().add(grid);
		menuBar.getMenus().add(menu);

		return menuBar;
	}

	/**
	 * Shows an alert with "txt" text.
	 * @param txt is error text.
	 */
	private void showErrorAlert(String txt) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setHeaderText(null);
		alert.setContentText(txt);
		alert.show();
	}

	/**
	 * Override updateItem to avoid missing pictures inside comboBox.
	 */
	private class imageCell extends ListCell<String> {
		@Override
		public void updateItem(String item, boolean empty) {
			super.updateItem(item, empty);

			if (empty) {
				setText(null);
				setGraphic(null);
			} else {
				setText(item);
				ImageView imageView = this.getImage(item);
				imageView.setFitHeight(100);
				imageView.setFitWidth(100);

				setGraphic(imageView);
			}
		}

		public ImageView getImage(String carType) {
			ImageView imageView = null;
			Image image = null;

			switch (carType) {
			case "Car":
				image = new Image(new File("res/pictures/Car0.jpg").toURI().toString());
				break;

			case "MonsterTruck":
				image = new Image(new File("res/pictures/truck.jpg").toURI().toString());
				break;

			case "Limo":
				image = new Image(new File("res/pictures/limo.jpg").toURI().toString());
				break;

			default:
				System.out.println("Could not find the car picture!");
				imageView = null;
			}

			imageView = new ImageView(image);
			return imageView;
		}
	}
}
