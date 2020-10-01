package Application;
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
        URL newURL = new File("F:\\OOP\\project\\src\\Application\\sample.fxml").toURI().toURL();
//        Parent root = FXMLLoader.load(newURL); F:\OOP\project\src

        Parent root = FXMLLoader.load(newURL);
        primaryStage.setTitle("TCDICTIONARY");
        primaryStage.setScene(new Scene(root, 670, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}