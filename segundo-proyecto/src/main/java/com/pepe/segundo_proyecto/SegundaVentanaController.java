package com.pepe.segundo_proyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SegundaVentanaController {

    @FXML
    private Label lbl;
    @FXML
    void saludar(ActionEvent event) {
    	lbl.setText("Hola desde la segunda ventana");
    }


}