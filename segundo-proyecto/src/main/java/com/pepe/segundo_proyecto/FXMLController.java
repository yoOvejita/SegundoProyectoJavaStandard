package com.pepe.segundo_proyecto;
/*
Put header here


 */

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
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
    @FXML
    private ImageView img;
    @FXML
    private TextField txtNombneElem;
    @FXML
    private CheckBox miCheck;
    @FXML
    private RadioButton rbf;

    @FXML
    private RadioButton rbm;

    @FXML
    private RadioButton rbo;
    @FXML
    private DatePicker calendario;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private Pane paneId;
    
    Stage stage;
    
    Image miImagen;
    
    
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
    
    @FXML
    void cambiarImagen(ActionEvent event) {
    	try {
    		miImagen = new Image(getClass().getResourceAsStream("/imagenes/" +txtNombneElem.getText() +".jpg"));
    		img.setImage(miImagen);
    	}catch(RuntimeException e) {
    		 Alert alerta = new Alert(AlertType.ERROR);
    	        alerta.setTitle("ERROR DE IMAGEN");
    	        alerta.setHeaderText("NOMBRE DE IMAGEN NO VALIDO");
    	        alerta.setContentText("Debe introducir un nombre de imagen valido: queso, atun");
    	        alerta.show();
    	}
    }
    @FXML
    void verificarCheck(ActionEvent event) {
    	if(miCheck.isSelected()) {
    		lblOut.setText("Acepta");
    		
    	}else {
    		lblOut.setText("No acepta");
    	}
    	
    	//RadioButtons
    	if(rbm.isSelected())
    		lblOut.setText(lblOut.getText()+ "; masculino.");
    	if(rbf.isSelected())
    		lblOut.setText(lblOut.getText()+ "; femenino.");
    	if(rbo.isSelected())
    		lblOut.setText(lblOut.getText()+ "; otro género.");
    	
    	//DatePicker
    	LocalDate fecha = calendario.getValue();
    	String fechaModificada = fecha.format(DateTimeFormatter.ofPattern("dd-/-MMM-=yyyy"));
    	lblOut.setText(lblOut.getText()+ "; " + fechaModificada);
    		
    	//ColorPicker & pane
    	Color color = colorPicker.getValue();
    	paneId.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY,null)));
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
