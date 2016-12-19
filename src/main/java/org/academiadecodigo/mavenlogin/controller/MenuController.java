package org.academiadecodigo.mavenlogin.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import org.academiadecodigo.mavenlogin.Navigation;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable{

    @FXML
    private MenuItem logoutButton;

    @FXML
    void doLogout(ActionEvent event) {
        Navigation.getInstance().back();
    }

    @FXML
    void goNext(ActionEvent event) {
        Navigation.getInstance().loadScene("next");
    }

    @FXML
    private MenuItem nextButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
