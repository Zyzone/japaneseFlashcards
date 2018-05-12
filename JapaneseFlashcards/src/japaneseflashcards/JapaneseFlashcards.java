/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package japaneseflashcards;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Zyzone
 */
public class JapaneseFlashcards {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> List = new ArrayList<>();
        ArrayList<String> Answers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        readFile(List, "Hiragana.txt");
        readFile(Answers, "Hiragana Answers.txt");
        
        String str;
        for(int i = 0; i < List.size(); i++) {
            System.out.print(List.get(i) + ": ");
            str = scanner.nextLine();
            if(str.equals(Answers.get(i))) {
                System.out.println("Corret! \n");
            }
            
        }
    }
 
    public static void readFile(ArrayList<String> Strings, String file) {
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            String str;
            while ((str = br.readLine()) != null) {
                if(str.contains("あ") || str.contains("ア")) {
                    Strings.add("" + str.charAt(1));                    
                }else {
                    Strings.add(str);
                }
            }
            br.close();
        }catch (IOException e) {
            System.out.println("File not found");
        }
    }
}