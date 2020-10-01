package Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import core.*;

public class Controller {
    @FXML
    private TextField word;
    @FXML
    public Text myWord;
    Dictionary newdick = new Dictionary();

    public void Submit (ActionEvent event){
        newdick.insertFromFile("F:\\OOP\\project\\src\\core\\data.txt");
        String answer = newdick.searchWord(word.getText());
        myWord.setText(answer);

    }
}
