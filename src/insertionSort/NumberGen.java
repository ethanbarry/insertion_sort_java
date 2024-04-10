package insertionSort;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class NumberGen {

    public static int size = 1000000;
    public static int[] numbers = new int[size];
    public static int min = 1;
    public static int max = 1000000;

    public static void numberGen(String[] args) {

        for (int x = 0; x < size; x++) {
            numbers[x] = getRand(min, max);
        }

        writeList(numbers, size, args[0]);

    }

    public static void writeList(int[] numbers, int size, String filename) {
        try {
            FileWriter fr = new FileWriter(filename, false);

            for (int x = 0; x < size; x++) {
                fr.write(numbers[x] + "\n");
            }
            System.out.println(" File sortme" + size + ".txt created");

            fr.close();
        } catch (IOException e) {
            System.out.println("File Error");
        }
    }

    public static int getRand(int min, int max) {
        if (min >= max) {
            System.out.println("Range Error: min greater than max");
            System.exit(1);
        }

        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
