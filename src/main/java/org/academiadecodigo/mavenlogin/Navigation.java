package org.academiadecodigo.mavenlogin;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by codecadet on 16/11/16.
 */
public final class Navigation {

    private static Navigation instance = null;
    private static final String VIEW_PATH = "/";
    private final int MIN_WIDTH = 1024; // window width
    private final int MIN_HEIGHT = 768; // window height

    private LinkedList<Scene> scenes = new LinkedList<Scene>(); // Navigation History
    private Map<String, Initializable> controllers = new HashMap<>(); //Container of controllers

    private Stage stage; // reference to the application window

    private Navigation(){

    }

    public void init(){

    }

    public static synchronized Navigation getInstance(){

        if(instance == null){
            instance = new Navigation();
        }

        return instance;
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

    public void loadScene(String view){

        try {

            // Instantiate the view and the controller
            FXMLLoader fxmlLoader;
            fxmlLoader = new FXMLLoader(getClass().getResource(VIEW_PATH + view + ".fxml"));

            fxmlLoader.setControllerFactory(new Callback<Class<?>, Object>() {

                @Override
                public Object call(Class<?> param) {
                    return controllers.get(param.getSimpleName()); // getController(param.getSimpleName());
                }
            });


            //loads the controller onto the root
            Parent root = fxmlLoader.load();

            //We don't need this anymore because we already put some controllers in the controllers map with spring

            /*//Store the controller
            controllers.put(view, fxmlLoader.<Initializable>getController());*/

            // Create a new scene and add it to the stack
            Scene scene = new Scene(root, MIN_WIDTH, MIN_HEIGHT);
            scenes.push(scene);

            // Put the scene on the stage
            setScene(scene);

        } catch (IOException e) {
            System.out.println("Failure to load view " + view + " : " + e.getMessage());
        }
    }

    private void setScene(Scene scene) {

        // set the scene
        stage.setScene(scene);

        // show the stage to reload
        stage.show();
    }

    public void back() {

        if (scenes.size() <= 1) {
            return;
        }

        // remove the current scene from the stack
        scenes.pop();

        // load the scene at the top of the stack
        setScene(scenes.peek());
    }

    public Initializable getController(String register){

        return controllers.get(register);
    }

    public void close() {

        stage.close();

    }


    public void setControllers(Map controllers) {
        this.controllers = controllers;
    }

    public Map getControllers() {
        return controllers;
    }
}
