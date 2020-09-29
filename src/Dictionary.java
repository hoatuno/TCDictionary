import java.io.*;
import java.util.*;

public class Dictionary {
    public List<Word> wordList = new ArrayList<>();

    public void insertFromCommandLine() {
        Scanner scanner = new Scanner(System.in);
        int numofWords = scanner.nextInt();
        scanner.nextLine();
        while (numofWords > 0) {
            String word = scanner.nextLine();
            String def = scanner.nextLine();
            Word wordObj = new Word(word, def);
            wordList.add(wordObj);
            numofWords--;
        }
    }

    public void showAllWords() {
        for (int i = 0; i < wordList.size(); i++) {
            String wd = wordList.get(i).getWord();
            String def = wordList.get(i).getDef();
            System.out.println(i + 1 + "      | " + wd + "            | " + def);
        }
    }

    public static void main(String[] args) {
        Dictionary dict = new Dictionary();
        dict.insertFromCommandLine();
        System.out.println(dict.wordList.size());
        dict.showAllWords();
    }

    public void dictionaryBasic() {


    }
    public  void insert(String Filename) throws IOException {
        // Đọc dữ liệu
        File file = new File(Filename);
        FileReader fis = new FileReader(file);
        BufferedReader br = new BufferedReader(fis);
        String line;
        int i = 0;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split("<html>");
            String word = parts[i];
            String definition = "<html>" + parts[i + 1];
            System.out.println(word);
            System.out.println("==> " + definition);
            Word wordObj = new Word(word, definition);
            wordList.add(wordObj);
            i++;
            if (i > 5) break;

        }
    }



}





