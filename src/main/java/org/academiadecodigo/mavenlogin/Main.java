package org.academiadecodigo.mavenlogin;

import javafx.application.Application;
import javafx.stage.Stage;
import org.academiadecodigo.mavenlogin.persistence.hibernate.HibernateSessionManager;
import org.academiadecodigo.mavenlogin.service.ServiceRegistry;
import org.academiadecodigo.mavenlogin.service.user.HibernateUserService;
import org.academiadecodigo.mavenlogin.service.user.UserService;
import org.academiadecodigo.mavenlogin.persistence.jdbc.ConnectionManager;


public class Main extends Application {

    static ConnectionManager manager = new ConnectionManager();
    @Override
    public void start(Stage primaryStage) throws Exception {


        //UserService userService = new jbdcUserService(manager);

        UserService userService = new HibernateUserService();

        System.out.println(userService.count());
        ServiceRegistry.getInstance().add(userService);

        Navigation.getInstance().setStage(primaryStage);
        Navigation.getInstance().loadScene("login");
        //((LoginController)Navigation.getInstance().getController("login")).setUserService(userService);



    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop(){
        System.out.println("Closing HibernateSessionManager");
        HibernateSessionManager.close();
        //manager.close();
    }
}
