import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;
import java.lang.String;
import java.lang.StringIndexOutOfBoundsException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.*;


public class TextAnalysis {

    private static Map<Character, Integer> letterMap;
    private static Map<String, Integer> wordMap;
    public static ArrayList<String> wordData = new ArrayList<String>();


    public static void main(String[] args) throws FileNotFoundException {

        Scanner scan = new Scanner(System.in);
        File file = new File("C:\\Users\\Nancy\\OneDrive - University of Iowa\\Desktop\\csprojects\\TextAnalysis\\untitled\\src\\words.txt");

        //fills wordData arrayList with words from the text
        getText(file);
        //cleans up text from punctuation, caps, spaced
        cleanText(wordData);
        System.out.println(wordData);
        letterFreq(wordData);

        System.out.println("Word Frequency");
        System.out.printf("%-20s %s%n", "Word", "Frequency");

        //streams
        wordMap.forEach((key, value) ->{

            System.out.printf("%-20s %s%n", key, value);

        });

        System.out.println("Letter Frequency");
        System.out.printf("%n%n%-20s %s%n", "Letter", "Frequency");
        letterMap.forEach((key, value) ->{

            System.out.printf("%-20s %s%n", key, value);

        });
    }

    public static void getText(File filename) throws FileNotFoundException {


        Scanner textFile = new Scanner(filename);


        while (textFile.hasNextLine()) {

            wordData.add(textFile.nextLine());
        }


    }

    public static void cleanText(List<String> lines) {
        ArrayList<String> cleanedData = new ArrayList<>();
        for (String line : lines) {
            String[] words = line.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase().split("\\s+");
            Collections.addAll(cleanedData, words);
        }
        wordData = cleanedData;
    }


    /**
     * Function to build the frequency of each letter
     *
     * @param lines
     */

    public static void letterFreq(ArrayList<String> lines) {

        wordMap = new TreeMap<>();
        letterMap = new TreeMap<>();


        for (String w : wordData) {

            if(!(w.trim().isEmpty())) {
                if (wordMap.get(w) == null) {
                    wordMap.put(w, 1);
                } else {
                    wordMap.put(w, wordMap.get(w) + 1);
                }

                for (int i = 0; i < w.length(); i++) {

                    char c = w.charAt(i);
                    if (letterMap.get(c) == null) {
                        letterMap.put(c, 1);
                    } else {
                        letterMap.put(c, letterMap.get(c) + 1);
                    }
                }

            }
        }


    }


}