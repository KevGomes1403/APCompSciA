import java.util.*;
import java.util.Scanner;

public class WordCount {
    public static void main(String args[])
    {
        // Start here!
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = sc.nextLine();

        int index = 0;
        int lastSpace = 0;
        char space = ' ';
        String sub1;
        String sub2;
        boolean isIn;

        HashMap<String, Integer> list = new HashMap<String, Integer>();

        for (int i = 0; i < input.length(); i++) {
            int counter = 0;
            isIn = false;
            char at = input.charAt(i);

            if (at == space || i == input.length() - 1) {
                index = i;
                if (i == input.length() - 1) {
                    index = i + 1;
                }

                sub2 = input.substring(lastSpace, index).toLowerCase();
                System.out.println("Looking for " + sub2);

                for (String word: list.keySet()) {
                    if (word.equals(sub2)) {
                        isIn = true;
                        break;
                    }
                }

                if (!isIn) {
                    for (int j = 0; j <= input.length() - index; j++) {
                        sub1 = input.substring(lastSpace + j, index + j).toLowerCase();

                        System.out.println("\tFound: " + sub1);

                        if (sub1.equals(sub2)) {
                            counter++;
                            System.out.println("\t\t Added to counter");
                        }
                    }

                    if (i == input.length() - 1) {
                        counter = 1;
                    }

                    list.put(sub2, counter);
                }

                lastSpace = i + 1;
            }

        }

        printSortedHashMap(list);

    }

    /*
     * This method takes a HashMap of word counts and prints out
     * each word and it's associated count in alphabetical order.
     *
     * @param wordCount The HashMap mapping words to each word's frequency count
     */
    private static void printSortedHashMap(HashMap<String, Integer> wordCount){
        // Sort all the keys (words) in the HashMap
        Object[] keys = wordCount.keySet().toArray();
        Arrays.sort(keys);

        // Print out each word and it's associated count
        for (Object word : keys) {
            int val = wordCount.get(word);
            System.out.println(word + ": " + val);
        }
    }
}
