import java.io.*;
import java.util.*;

public class CountLetters {
    public static void main(String str[]) throws IOException
    {
        /*
         * Initialize an ArrayList of animals called zoo.
         */
        ArrayList<String> zoo = new ArrayList<String>();
        zoo.add("Zebra");
        zoo.add("Aardvark");
        zoo.add("Emu");
        zoo.add("Hippo");
        zoo.add("Aligator");
        zoo.add("Lion");
        zoo.add("Giraffe");
        zoo.add("Seal");
        zoo.add("Tiger");
        zoo.add("Elephant");

        /*
         * Print the contents of the zoo.
         */
        System.out.println(zoo);

        /*
         * Print the output from calling countLetter with various letters. For
         * example, countLetter (zoo, "e") should return 2 while
         * countLetter(zoo, "W") should return 0.
         */
        System.out.println("A: " + countLetter(zoo, "A"));
        System.out.println("B: " + countLetter(zoo, "B"));
        System.out.println("C: " + countLetter(zoo, "C"));
        System.out.println("L: " + countLetter(zoo, "L"));
        System.out.println("T: " + countLetter(zoo, "T"));

        System.out.println("a: " + countLetter(zoo, "a"));
        System.out.println("b: " + countLetter(zoo, "b"));
        System.out.println("c: " + countLetter(zoo, "c"));
        System.out.println("l: " + countLetter(zoo, "l"));
        System.out.println("t: " + countLetter(zoo, "t"));
    }

    public static int countLetter(ArrayList<String> list, String letter)
    {
        int result = 0;

        for (String str: list) {
            if (str.substring(0,1).toLowerCase().equals(letter.toLowerCase())) {
                result++;
            }
        }

        return result;
    }

}
