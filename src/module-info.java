module RadioControlledCar {
	opens model;
	opens view;
	opens test;

	requires transitive java.desktop;
	requires javafx.graphics;
	requires javafx.controls;
	requires javafx.base;
	requires junit;
}