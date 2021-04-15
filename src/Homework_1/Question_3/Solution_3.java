package Homework_1.Question_3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/1/28 19:58
 *   @Description :
 *
 */
public class Solution_3 {

    private static final String path = "src/Homework_1/Question_3/data.txt";
    List<String> lines;
    Map<String, Integer> wordFreq;
    Map<Character, Integer> letterFreq;
    TreeMap<String, Integer> sorted;

    public Solution_3(){
        this.lines = new ArrayList<>();
        this.wordFreq = new HashMap<>();
        this.letterFreq = new HashMap<>();
    }
    // a
    public void readPrint(String path){
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
                addToList(line);
            }
        } catch (FileNotFoundException e1){
            e1.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    // b
    public void addToList(String str){
        lines.add(str);
    }
    // c
    public void toLower(){
       for(int i = 0; i < this.lines.size(); i++){
           String str = this.lines.get(i);
           lines.set(i, str.toLowerCase());
       }
    }
    private void countWordFreq(){
        for(String str: lines){
            String[] strings = str.split(" ");
            for(String string:strings){
                wordFreq.putIfAbsent(string, 0);
                wordFreq.put(string, wordFreq.get(string) + 1);
            }
        }
    }
    private void countLetterFreq(){
        for(String str: lines){
           String[] strings = str.split(" ");
           for(String string : strings){
               for(char c : string.toCharArray()){
                   letterFreq.putIfAbsent(c, 0);
                   letterFreq.put(c, letterFreq.get(c) + 1);
               }
           }
        }
    }
    // f
    public void sort(){
        this.sorted = new TreeMap<>((a, b) -> (this.wordFreq.get(a) != this.wordFreq.get(b) ? this.wordFreq.get(b) - this.wordFreq.get(a) : b.compareTo(a)));
        for(Map.Entry<String, Integer> entry : this.wordFreq.entrySet()){
            Integer val = entry.getValue();
            String key = entry.getKey();
            this.sorted.put(key, val);
        }
    }
    public static void main(String[] args) {
        Solution_3 s = new Solution_3();
        // a, b) print it on the console and add it to list with try catch
        s.readPrint(path);
        // c)  read it from the list and change it to lower-case
        s.toLower();
        System.out.println("Print the sentence in lower case +++++++++");
        for(String str : s.lines){
            System.out.println(str);
        }
        // d, e) count the word and letter
        int wordCount = 0, letterCount = 0;
        for(String str: s.lines){
            String[] strings = str.split(" ");
            wordCount += strings.length;
            for(String string : strings){
                letterCount += string.length();
            }
        }
        System.out.println("Print the wordCount and letter Count");
        System.out.println("WordCount : " + wordCount + " and " + "Letter Count : " +letterCount);
        // e, f)
        s.countWordFreq();
        s.countLetterFreq();
        s.sort();
        // g)
        for(Map.Entry<String, Integer> entry: s.sorted.entrySet()){
            System.out.print(entry.getKey() + " ");
        }
    }
}
