/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package japaneseflashcards;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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
        
        File folder = new File("C:\\Users\\Zyzone\\Git_Projects\\japaneseFlashcards\\JapaneseFlashcards");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile() && listOfFiles[i].toString().endsWith("txt")) {
                System.out.println("File " + listOfFiles[i].getName());
            } 
        }
        
        setFile(List, Answers, scanner);        
        nextProblem(List, Answers, scanner);
    }
 
    //Adds strings from file to the ArrayList Strings
    public static boolean readFile(ArrayList<String> Strings, String file) {
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
            return true;
        }catch (IOException e) {
            System.out.println("File not found");
            return false;
        }
    }
    
    //Allows user to enter names for list and answers file
    public static void setFile(ArrayList<String> list, ArrayList<String> answers, Scanner scanner) {
        String str;
        
        while(true) {
            System.out.print("Enter the name of the List file:");
            str = scanner.nextLine();
            if(readFile(list, str)) {
                break;
            }
        }
        
        while(true) {
            System.out.print("Enter the name of the Answer file:");
            str = scanner.nextLine();
            if(readFile(answers, str)) {
                break;
            } 
        }
    }
    
    //Gets the next problem from the list file; compares given answer to the answers file
    public static void nextProblem(ArrayList<String> list, ArrayList<String> answers, Scanner scanner) {
        String str;
        
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ": ");
            str = scanner.nextLine();
            if(str.equals(answers.get(i))) {
                System.out.println("Corret! \n");
            }
            
        }   
    }
}