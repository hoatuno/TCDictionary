package Application;

import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private TextField word, addword, defword, delword;
    @FXML
    private JFXTextArea jfxtect;
    @FXML
    private Text myWord;
    @FXML
    private WebView webview = new WebView();
    @FXML
    private Button btnlookup, btntrans, buttonedit;

    public void Submit (ActionEvent event) throws IOException, SQLException {
        SQLiteDatabaseActions actions = new SQLiteDatabaseActions();
        String answer = actions.queryforHtml(word.getText());
        final WebEngine engine = webview.getEngine();

        engine.loadContent(answer);
    }
    public void translate (ActionEvent event) throws IOException {
        TranslatorAPI translatorAPI = new TranslatorAPI();
        String answer = translatorAPI.result(jfxtect.getText()); // the cai nao tra ve string
        myWord.setText(answer);
    }
    public void addWord (ActionEvent event) throws IOException {
        SQLiteDatabaseActions actions = new SQLiteDatabaseActions();
        actions.insertWord(addword.toString(), defword.toString());
    }
    public void deleteWord (ActionEvent event) throws IOException {
        SQLiteDatabaseActions actions = new SQLiteDatabaseActions();
        actions.deleteWord(delword.toString());
    }

    @FXML
    private void handleButtonAction (ActionEvent event) throws Exception {
        Stage stage;
        Parent root;

        if(event.getSource()==btnlookup){
            stage = (Stage) btnlookup.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        }
        else  if(event.getSource()==btntrans){
            stage = (Stage) btntrans.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("translate.fxml"));
        }
        else {
            stage = (Stage) buttonedit.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("editdata.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
