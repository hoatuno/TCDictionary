package Application;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
            Parent root = loader.load();

            Controller controller = loader.getController();

//            new AnimationTimer() {
//                public void handle(long currentNanoTime) {
//                    List<String> list = null;
//                    try {
//                        list = controller.actions.realtimeSearch(controller.getWord());
//                    } catch (SQLException throwables) {
//                        throwables.printStackTrace();
//                    }
//                    ObservableList<String> observableList = FXCollections.observableArrayList(list);
//                    controller.getListview().setItems(observableList);
//                }
//            }.start();

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