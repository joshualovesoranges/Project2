import java.util.ArrayList;
import java.util.Random;

public class HashTester {
    public static void main(String[] args) {
        //initializes hashmap
        JoshuaSimpleHashmap hashmap = new JoshuaSimpleHashmap();
        hashmap.initialize();

        int numItems = 10000;//number of Strings to be added to the dataset array
        Random rand = new Random();//using the random class

        String[] dataset = new String[numItems];//creates an empty String array
        //adds 10000 randomly generated strings into the array
        for (int i = 0; i < numItems; i++) {
            dataset[i] = generateRandomString(rand, 5 + rand.nextInt(10));
        }

        //used https://stackoverflow.com/questions/6919881/how-can-i-prove-that-one-algorithm-is-faster-than-another-in-java to help me time the runtime of my hashmap
        long startTime = System.nanoTime();
        //adds all the Strings into my hashmap
        for (String s : dataset) {
            hashmap.add(s);
        }
        long endTime = System.nanoTime();

        //displays the runtime of my hashmap in ms by dividing by 1,000,000
        System.out.println("Total time to insert " + numItems + " strings: " + (endTime - startTime) / 1000000 + " ms");
        System.out.println("Number of resizes: " + hashmap.resizeCount);//displays how many times my hashmap was resized
        System.out.println("Final size of array: " + hashmap.size);//displays the final size of my hashmap


    }

    //method to generate a random String
    private static String generateRandomString(Random rand, int length) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";//all the letters in the alphabet
        ArrayList<String> sb = new ArrayList<>();//an array to hold the randomly generated chars to form a string
        for (int i = 0; i < length; i++) {
            //adds a random letter from the alphabet
            sb.add(String.valueOf(alphabet.charAt(rand.nextInt(alphabet.length()))));
        }
        //returns the String version of the array of random letters
        return sb.toString();
    }
}
