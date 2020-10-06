package core;

import java.io.*;
import java.util.*;
import edu.princeton.cs.algs4.*;


public class Dictionary {
    Scanner scanner = new Scanner(System.in);
    public List<Word> wordList = new ArrayList<>();

    public void insertFromCommandLine() {

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


    // read in data from .txt file, tab delimiter.

    public void insertFromFile(String filename) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filename));
            String content = bufferedReader.readLine();
            while (content != null) {
                //System.out.println(content);
                String[] splitcontent = content.split("\\t", -1);
                String word = splitcontent[0];
                String def = splitcontent[1];
                Word wordobj = new Word(word, def);
                wordList.add(wordobj);
                content = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void exportToFile(String filepath) {
        int l = wordList.size();
        try {
            File file = new File(filepath);
            FileWriter fileWriter = new FileWriter(file);
            for (Word value : wordList) {
                String word = value.getWord();
                String def = value.getDef();
                String tab = "\t";
                String ln = "\n";
                fileWriter.write(word);
                fileWriter.write(tab);
                fileWriter.write(def);
                fileWriter.write(ln);
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void DictionarySearcher() {
        Scanner scanner = new Scanner(System.in);
        String lookfor = scanner.nextLine();
        int l = lookfor.length();
        String[] listofword = new String[wordList.size()];
        for (int i = 0; i < wordList.size(); i++) {
            listofword[i] = wordList.get(i).getWord();
        }
        // if every lookfor's char == first lookfor.length characters of a word, print out the word.
        for (int i = 0; i < wordList.size(); i++) {
            // ignore word with less characters than that of the string requested.
            if (listofword[i].length() >= l) {
                int cnt = 0;
                for (int j = 0; j < l; j++) {
                    if (listofword[i].charAt(j) == lookfor.charAt(j)) {
                        cnt++;
                    }
                }
                if (cnt == l) System.out.println(listofword[i]);
            }

        }
    }

    public void DictionaryLookUp() {

        String word = scanner.nextLine();
        int size = wordList.size();
        String[] listofword = new String[wordList.size()];
        for (int i = 0; i < wordList.size(); i++) {
            listofword[i] = wordList.get(i).getWord();
        }
        for(int i=0; i<size; i++) {
            if (listofword[i].equals(word)) {
                System.out.println(wordList.get(i).getDef());
            }
        }
    }
    public  String searchWord(String word) {
        int size = wordList.size();
        String[] listofword = new String[wordList.size()];
        for (int i = 0; i < wordList.size(); i++) {
            listofword[i] = wordList.get(i).getWord();
        }
        for(int i=0; i<size; i++) {
            if (listofword[i].equals(word)) {
                return wordList.get(i).getDef();
            }
        }
        return "404 not found";
    }

    public static void main(String[] args) throws IOException {
        Dictionary dict = new Dictionary();

<<<<<<< HEAD:src/core/Dictionary.java

        dict.insertFromFile("F:\\OOP\\project\\src\\data.txt");
=======
        dict.getAll("D:\\New folder\\src\\dat.txt");
        //dict.insertFromFile("D:\\New folder\\src\\data.txt");
>>>>>>> 4178cc942c48f23405b934753cb6be3e8131b542:src/Dictionary.java
        //dict.DictionarySearcher();
        System.out.println(dict.wordList.size());
        //dict.showAllWords();
        //dict.DictionaryLookUp();
<<<<<<< HEAD:src/core/Dictionary.java
        dict.exportToFile("F:\\OOP\\project\\src\\out-data.txt");
=======
        //dict.exportToFile("D:\\New folder\\src\\out-data.txt");
    }

    public void getAll(String filepath) {
        
>>>>>>> 4178cc942c48f23405b934753cb6be3e8131b542:src/Dictionary.java
    }

    //public void dictionaryBasic() {


    //}
}





