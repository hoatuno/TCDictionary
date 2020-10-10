package Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import core.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.IOException;

public class Controller {
    @FXML
    private TextField word;
    @FXML
    private Text myWord;
    @FXML
    private WebView webview = new WebView();
    Dictionary newdick = new Dictionary();

    public void Submit (ActionEvent event) throws IOException {
        newdick.insertFromFile("F:\\OOP\\project\\src\\core\\data.txt");
        String answer = newdick.queryforHtml(word.getText());
       // myWord.setText(answer);
       // String html = "<h1>adroitness</h1><h3><i>/ə'drɔitnis/</i></h3><h2>danh từ</h2><ul><li>sự khéo léo, sự khéo tay</li></ul>";
        //answer = mano.translate ("en","vi",word.getText());
        final WebEngine engine = webview.getEngine();
        //engine.setUserStyleSheetLocation(getClass().getClassLoader().getResource("dictionaryStyle.css").toString());

        engine.loadContent(answer);
    }
}
