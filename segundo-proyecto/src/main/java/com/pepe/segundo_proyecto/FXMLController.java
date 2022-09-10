package com.pepe.segundo_proyecto;
/*
Put header here


 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class FXMLController implements Initializable {
    
    @FXML
    private Label lblOut;
    @FXML
    private TextField txtUsuario;
    @FXML
    private Button btnClick;
    @FXML
    private Line linea;
    
    Stage stage;
    
    
    @FXML
    private void btnClickAction(ActionEvent event) {
    	String valor = txtUsuario.getText();
    	
        lblOut.setText("Hello World! ");
        lblOut.setText(lblOut.getText() + valor);
        
        btnClick.setText("NO TOCAR");
        
        Alert alerta = new Alert(AlertType.CONFIRMATION);
        alerta.setTitle("Salir");
        alerta.setHeaderText("Estás a punto de salir");
        alerta.setContentText("¿Estás seguro de salir?");
        if(alerta.showAndWait().get() == ButtonType.OK) {
        	Node nodo = (Node) event.getSource();
        	stage = (Stage)nodo.getScene().getWindow();
        	stage.close();
        }
    }
    
    @FXML
    void btnDibujarLinea(ActionEvent event) {
    	//Figuras en la escena
        linea.setStartX(50);
        linea.setStartY(50);
        linea.setEndX(100);
        linea.setEndY(200);
        linea.setStrokeWidth(10);
        linea.setStroke(Color.RED);
        linea.setOpacity(.5);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
