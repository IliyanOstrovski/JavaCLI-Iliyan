package com.company;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> map = new HashMap<>();

        while (true) {
            String[] input = scanner.nextLine().split(" ");
            if ("exit".equalsIgnoreCase(input[0])) {
                break;
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
            if (input[0].equals("reverse")) {
                String word = "Walltopia the best!";
                String[] reverse = word.split(" ");
                String resultOfRev = "";

                for (int i = 0; i < reverse.length; i++) {
                    String letters = reverse[i];
                    String revWord = "";

                    for (int j = letters.length() -1; j >= 0; j--) {
                        revWord= revWord + letters.charAt(j);
                    }
                    resultOfRev = resultOfRev + revWord + " ";


                }
                System.out.println(reverseWords(resultOfRev));
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

