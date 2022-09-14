package com.pepe.segundo_proyecto;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class MainApp extends Application {
    private static Stage stage;
    private static FXMLController controller;

    @Override
    public void start(@SuppressWarnings("exports") Stage s) throws IOException {
        stage=s;
        setRoot("primary","");
    }

    static void setRoot(String fxml) throws IOException {
        setRoot(fxml,stage.getTitle());
    }

    static void setRoot(String fxml, String title) throws IOException {
        Scene scene = new Scene(loadFXML(fxml));
        
        
        
        scene.getStylesheets().add(MainApp.class.getResource("/styles/archivo.css").toExternalForm());
        stage.setTitle(title);
        //PAra escuchar tecleadas
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				System.out.println("Tecla presionada");
				switch(event.getCode()){
				case UP:
					FXMLController.moverArriba();
					break;
				case DOWN:
					FXMLController.moverAbajo();
					break;
				default:
						System.out.println("Tecla detectada pero no soportada");
						break;
        		}
			}
        	
        });
        stage.setScene(scene);
        
        stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/fxml/"+fxml + ".fxml"));
        controller = fxmlLoader.getController();
        return fxmlLoader.load();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
