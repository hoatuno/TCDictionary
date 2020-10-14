package Application;

import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import core.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Controller {
    @FXML
    private TextField word;
    @FXML
    private JFXTextArea jfxtect;
    @FXML
    private Text myWord;
    @FXML
    private WebView webview = new WebView();
    @FXML
    private Button btnlookup,btntrans;


    public void Submit (ActionEvent event) throws IOException, SQLException {
        Dictionary newdict = new Dictionary();
        SQLiteDatabaseActions actions = new SQLiteDatabaseActions();
        newdict.insertFromFile("F:\\OOP\\project\\src\\core\\data.txt"); // tim ho t cai nay
        String answer = actions.queryforHtml(word.getText());
       // myWord.setText(answer);
       // String html = "<h1>adroitness</h1><h3><i>/ə'drɔitnis/</i></h3><h2>danh từ</h2><ul><li>sự khéo léo, sự khéo tay</li></ul>";
        //answer = mano.translate ("en","vi",word.getText());
        final WebEngine engine = webview.getEngine();
        //engine.setUserStyleSheetLocation(getClass().getClassLoader().getResource("dictionaryStyle.css").toString());

        engine.loadContent(answer);
    }
    public void translate (ActionEvent event) throws IOException {
        TranslatorAPI translatorAPI = new TranslatorAPI();
        String answer = translatorAPI.result(jfxtect.getText()); // the cai nao tra ve string
        myWord.setText(answer);

    }

    @FXML
    private void handleButtonAction (ActionEvent event) throws Exception {
        Stage stage;
        Parent root;

        if(event.getSource()==btnlookup){
            stage = (Stage) btnlookup.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        }
        else{
            stage = (Stage) btntrans.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("translate.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
