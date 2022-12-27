package com.company;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
            Scanner scanner = new Scanner(System.in);
            Map<String, Integer> map = new HashMap<>();

            while (true) {
                String fullCommand = scanner.nextLine();
                String[] input = fullCommand.split(" ");

                if ("exit".equalsIgnoreCase(input[0])) {
                    break;
                }

                if (input[0].isEmpty()){
                    System.out.println("Command does not exist");
                }
                if (input[0].equals("set")) {
                    map.put(input[1], Integer.valueOf(input[2]));
                }
                if (input[0].equals("get")) {
                    input[1].equals(map);
                    map.entrySet()
                            .stream()
                            .map(entry ->
                                    String.join(" ", entry.getKey(), entry.getValue().toString()))
                            .forEach(System.out::println);
                }
                if (input[0].equals("save")){
                    String outputFilePath = input[1];
                    File file = new File(outputFilePath);
                    BufferedWriter bf = null;

                    try {
                        bf = new BufferedWriter(new FileWriter(file));

                        for (Map.Entry<String, Integer> entry :
                            map.entrySet()){
                            bf.write(entry.getKey() + " " + entry.getValue());
                            bf.newLine();
                        }
                        bf.flush();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    finally {
                        try {
                            bf.close();
                        }catch (Exception e){
                        }
                    }

                }
                if (input[0].equals("reverse")  && !input[1].isEmpty()) {
                    String word = input[1];
                    String[] reverse = word.split(" ");
                    String resultOfRev = "";

                    for (int i = 0; i < reverse.length; i++) {
                        String letters = reverse[i];
                        String revWord = "";

                        for (int j = letters.length() - 1; j >= 0; j--) {
                            revWord = revWord + letters.charAt(j);
                        }
                        resultOfRev = resultOfRev + revWord + " ";


                    }
                    System.out.println(reverseWords(resultOfRev));
                }
                if (input[0].equals("count-words")  && !input[1].isEmpty()) {
                    String path = input[1];
                    int charCount = 0;
                    int wordCount = 0;
                    BufferedReader reader;
                    try {
                        reader = new BufferedReader(new FileReader(path));
                        String currLine = reader.readLine();

                        while (currLine != null) {
                            String words[] = currLine.split(" ");
                            wordCount = wordCount + words.length;
                            for (String word : words) {
                                charCount = charCount + word.length();
                            }
                            currLine = reader.readLine();
                        }
                        System.out.println("Words in files are " + charCount);
                    } catch (FileNotFoundException e) {
                        System.out.println("File does not exist!");
                        continue;
                    } catch (IOException e) {
                        System.out.println("File does not exist!");
                        continue;
                    }
                }
            }
    }
    public static String reverseWords(String s){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')continue;
            int start = i;
            while(i<s.length()&& s.charAt(i) != ' ') i++;
            if (result.length() == 0)
            result.insert(0, s.substring(start, i));
            else
                result.insert(0, " ").insert(0, s.substring(start, i));
        }
        return result.toString();
    }
}

