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
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

            Scene searchScene = new Scene(root);

            primaryStage.setTitle("TCDICTIONARY");
            primaryStage.setScene(searchScene);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}