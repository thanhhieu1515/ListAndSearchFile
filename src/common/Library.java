
package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import model.TextFile;


public class Library {
    Scanner sc = new Scanner(System.in);
    
    public String getValue(String msg){
        System.out.print(msg);
        return sc.nextLine();
    }
    
    public int getIntForMenu(String msg, int min, int max){
        int a = -1;
        while(true){
            System.out.print(msg);
            try {
                a = Integer.parseInt(sc.nextLine());
                if(a >= min && a <= max){
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number between " + min + " and " + max);
            }
        }
        return a;
    }
    
    public int getInteger(String msg){
        int a = -1;
        while (true) {            
            System.out.println(msg);
            try {
                a = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Only input number");
                continue;
            }
            break;
        }
        return a;
    }
    
    public int countWordInFile(String fileSource, String word) {
        FileReader fr = null;
        TextFile textFile = new TextFile(fileSource);
        try {
            fr = new FileReader(textFile.getPathFile());
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            int count = 0;
            while (line != null) {
                String[] parts = line.split(" ");
                for (String w : parts) {
                    if (w.equalsIgnoreCase(word)) {
                        count++;
                    }
                }
                line = br.readLine();
            }
            return count;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }
    
    public void getFileNameContainsWordInDirectory(String source, String word) {
        TextFile folderPath = new TextFile(source);
        File folder = new File(folderPath.getPathFile());
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                if (countWordInFile(file.getAbsolutePath(), word) != 0) {
                    System.out.println("file name: " + file.getName());
                }
            }
        }
    }
}
