package org.academiadecodigo.mavenlogin.controller;

import javafx.fxml.Initializable;
import org.academiadecodigo.mavenlogin.Navigation;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by codecadet on 06/12/16.
 */
public class MainController implements Initializable {


    private static final String NAME = "main";

    public static String getName() {
        return NAME;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void onQuit() {

        Navigation.getInstance().close();

    }

    public void onLogout() {

        Navigation.getInstance().back();

    }
}

