package org.academiadecodigo.mavenlogin.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import org.academiadecodigo.mavenlogin.Navigation;
import org.academiadecodigo.mavenlogin.model.User;
import org.academiadecodigo.mavenlogin.service.ServiceRegistry;
import org.academiadecodigo.mavenlogin.service.user.UserService;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private UserService userService;
    private boolean isLogin = true;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView img;

    @FXML
    private ImageView img2;

    @FXML
    private Label cadet;

    @FXML
    private Label passLabel;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Label email;

    @FXML
    private TextField emailField;

    @FXML
    private Button login;

    @FXML
    private Label error;

    @FXML
    private Button register;

    public void setTextsForLogin(){

        login.setText("Login");
        error.setText("");
        register.setText("Register");
        email.setVisible(false);
        emailField.setVisible(false);
    }

    public void setTextsForRegistration(){

        login.setText("Cancel");
        error.setText("");
        register.setText("Confirm");
        emailField.setVisible(true);
        email.setVisible(true);
    }

    @FXML
    void doLogin(ActionEvent event) {
        if(isLogin) {
            if(!username.getText().equals("") && !password.getText().equals(""))
                if (userService.authenticate(username.getText(), password.getText()))
                    Navigation.getInstance().loadScene("menu");
                else
                    error.setText("Wrong Credentials");
            else
                error.setText("Wrong Credentials");
        } else{
            setTextsForLogin();
            isLogin = true;
        }
    }

    @FXML
    void doRegistration(ActionEvent event) {
        if(!isLogin){
            System.out.println(checkUser());
            if(!checkUser()) {
                User user = new User();
                user.setUsername(username.getText());
                user.setEmail(emailField.getText());
                user.setPassword(password.getText());
                userService.add(user);
                error.setText("User Registred");
            }else
                error.setText("Wrong Credentials");
        }
        else{
            setTextsForRegistration();
            isLogin = false;
        }
    }

    public boolean checkUser(){

        return username.getText().equals("") || password.getText().equals("") || emailField.getText().equals("");

    }


    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userService = (UserService)ServiceRegistry.getInstance().getRegistry("hibernate");
    }


}
