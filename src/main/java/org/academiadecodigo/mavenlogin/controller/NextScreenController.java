package org.academiadecodigo.mavenlogin.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import org.academiadecodigo.mavenlogin.Navigation;

import java.net.URL;
import java.util.ResourceBundle;

public class NextScreenController implements Initializable{

    @FXML
    private MenuItem backButton;

    @FXML
    void goBack(ActionEvent event) {
        Navigation.getInstance().back();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
