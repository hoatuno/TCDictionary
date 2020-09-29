package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        URL newURL = new File("F:\\OOP\\project\\app\\src\\main\\java\\sample\\sample.fxml").toURI().toURL();
//        Parent root = FXMLLoader.load(newURL);

        Parent root = FXMLLoader.load(newURL);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 851, 640));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}