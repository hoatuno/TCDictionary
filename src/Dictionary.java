import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {

    public static void main(String[] args) throws IOException {
        // Đọc dữ liệu
        FileReader fis = new FileReader("E_V.txt");
        BufferedReader br = new BufferedReader(fis);
        List<Word> wordList = new ArrayList<Word>();
        String line;
        int i = 0;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split("<html>");
            String word = parts[0];
            String definition = "<html>" + parts[1];
            System.out.println(word);
            System.out.println("==> " + definition);
            Word wordObj = new Word(word, definition);
            wordList.add(wordObj);
            i++;
            if (i > 5) break;
        }

        // Cập nhật 1 từ
        for (Word word : wordList) {
            if (word.getWord().equals("-manship")) {
                word.setDef("<html>Nghĩa mới</html>");
            }
        }
        FileWriter fw = new FileWriter("E_V.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        for (Word word : wordList) {
            bw.write(word.getWord() + word.getDef() + "\n");
        }
        bw.flush();
        bw.close();
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