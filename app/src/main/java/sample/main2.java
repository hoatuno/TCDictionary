package sample;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.scene.layout.Panel;
public class main2 extends Application  {

        @Override
        public void start(Stage primaryStage) throws Exception {                   //(1)
            HBox root = new HBox();
            root.setSpacing(20);

            Panel panel = new Panel("TCDictionary");
            panel.getStyleClass().add("panel-primary");                            //(2)
            Button button = new Button("Translate");
            button.getStyleClass().setAll("btn","btn-danger");                     //(2)

            TextField text1 = new TextField();

            root.getChildren().add(button);
            root.getChildren().add(text1);


            panel.setBody(root);

            Button btn = new Button("Go back");
            btn.getStyleClass().setAll("btn-success");


            panel.setFooter(btn);


            Scene scene = new Scene(panel, 1000, 600);
            scene.getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css"); //(3)

            primaryStage.setTitle("BootstrapFX");
            primaryStage.setScene(scene);
            primaryStage.sizeToScene();
            primaryStage.show();

    }
}
