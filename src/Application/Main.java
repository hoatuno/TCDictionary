package Application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try{

        URL newURL = new File("F:\\OOP\\project\\src\\Application\\sample.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(newURL);
        String html = "<html><h1>Hello</h1><h2>Hello</h2></html>";
        WebView webview = new WebView();
        WebEngine webtext = webview.getEngine();
        webtext.loadContent(html);


        Scene searchScene = new Scene(root, 670, 600);


        primaryStage.setTitle("TCDICTIONARY");
        primaryStage.setScene(searchScene);

        primaryStage.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}