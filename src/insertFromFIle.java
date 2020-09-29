import java.io.*;
// this class takes responsibility for reading/writing from/to files
public class FileReader {


    public static Dictionary FileReader (Dictionary dictionary){
          // Đọc dữ liệu
          FileReader fis = new FileReader("data.txt");
          BufferedReader br = new BufferedReader(fis);

          String line;
          int i = 0;
          while ((line = br.readLine()) != null) {
              String[] parts = line.split("<html>");
              String word = parts[0];
              String definition = "<html>" + parts[1];
              System.out.println(word);
              System.out.println("==> " + definition);
              Word wordObj = new Word(word, definition);
              dictionary.wordList.add(wordObj);
              i++;
              if (i > 5) break;
          }
      }




}
