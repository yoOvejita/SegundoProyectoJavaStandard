package com.pepe.segundo_proyecto;
/*
Put header here


 */

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

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
    @FXML
    private ChoiceBox<String> miChoice;
    @FXML
    private Label valorChoice;
    @FXML
    private Slider miSlider;
    @FXML
    private Label lblSlider;
    @FXML
    private ProgressBar miBarra;
    @FXML
    private Circle circulo;
    @FXML
    private Rectangle rectangulo;
    @FXML
    private Button btnInstalar;

    Stage stage;

    Image miImagen;

    Double progreso = 0.0;


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

    	//ChoiceBox
    	String miElem = miChoice.getValue();
    	valorChoice.setText("Se eligió el valor: " + miElem);
    	
    	//ProgressBar
    	miBarra.setStyle("-fx-accent: red;");
    	
    	progreso += 0.1;
    	miBarra.setProgress(progreso);
    	Random rnd = new Random();
    	int valor = rnd.nextInt(200);
    	
    	//Animaciones
    	TranslateTransition translate = new TranslateTransition();
    	translate.setNode(btnInstalar);
    	translate.setDuration(Duration.millis(5000));
    	translate.setByX(valor);
    	translate.setByY(-100);
    	translate.setAutoReverse(true);
    	translate.play();
    	
    	RotateTransition rotate = new RotateTransition();
    	rotate.setNode(btnInstalar);
    	rotate.setDuration(Duration.millis(3000));
    	rotate.setCycleCount(5);
    	rotate.setInterpolator(Interpolator.LINEAR);
    	rotate.setToAngle(360);
    	rotate.setAxis(Rotate.Z_AXIS);
    	rotate.play();

    	
    	FadeTransition fade = new FadeTransition();
    	fade.setNode(btnInstalar);
    	fade.setDuration(Duration.millis(5500));
    	fade.setCycleCount(2);
    	fade.setInterpolator(Interpolator.LINEAR);
    	fade.setFromValue(1);
    	fade.setToValue(0);
    	fade.play();
    	
    	ScaleTransition scale = new ScaleTransition();
    	scale.setNode(btnInstalar);
    	scale.setFromX(1);
    	scale.setToX(2);
    	scale.setFromY(1);
    	scale.setToY(2);
    	scale.setDuration(Duration.millis(2000));
    	scale.setCycleCount(3);
    	scale.play();
    	

    }
    @Override
	public void initialize(URL url, ResourceBundle rb) {
    	String[] elementos = {"uno","dos","tres"};
        miChoice.getItems().addAll(elementos);

        miSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				int miTemperatura = (int)miSlider.getValue();
				lblSlider.setText(miTemperatura + " ºC");
			}

        });
    }
    
    public static void moverArriba() {
    	System.out.println("Moviendo arriba");
    }
    public static void moverAbajo() {
    	System.out.println("Moviendo abajo");
    }
}
