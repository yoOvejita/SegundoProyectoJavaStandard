module com.pepe {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
	requires javafx.graphics;
	requires java.desktop;
    opens com.pepe.segundo_proyecto to javafx.fxml;
    exports com.pepe.segundo_proyecto;
}