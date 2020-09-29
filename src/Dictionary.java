import java.io.*;
import java.util.*;

public class Dictionary {
   List<Word> wordList = new ArrayList<>();
     class DictionaryManagement {
        Dictionary dictionary = new Dictionary();

        public void insertFromCommandLine() {

            }
        }
    }
    class DictionaryCommandline {

        Dictionary dictionary = new Dictionary();

        public void showAllWords() {
            for(int i=0; i< dictionary.wordList.size(); i++) {
                String wd = dictionary.wordList.get(i).getWord();
                String def = dictionary.wordList.get(i).getDef();
                System.out.println(i+1 + "      | " + "wd" + "            | " + "def");
            }
        }
    }
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        Scanner scanner = new Scanner(System.in);
        int numofWords = scanner.nextInt();
        scanner.nextLine();
        while (numofWords > 0) {

            String word = scanner.nextLine();
            String def = scanner.nextLine();
            Word wordObj = new Word(word, def);
            dictionary.wordList.add(wordObj);
            numofWords--;

        //dcl.showAllWords();
    }

}

class Word {
    private String word;
    private String def;

    public Word(String word, String def) {
        this.word = word;
        this.def = def;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDef() {
        return def;
    }

    public void setDef(String def) {
        this.def = def;
    }
}






