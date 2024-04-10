package insertionSort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class Main {

    public static void main(String[] args) {
                
        if (args.length < 1) {
            System.out.println("Usage:\n\tjava BubbleSort [filename]");
            System.exit(1);
        }
        
        NumberGen.numberGen(args);
        
        try {
            var freader = new FileReader(args[0]);
            var breader = new BufferedReader(freader);

            var array = new int[1_000_000];
            var line = breader.readLine();
            
            var idx = 0;
            while (line != null) {
                array[idx] = Integer.parseInt(line);
                line = breader.readLine();
                idx++;
            }
            
            System.out.println("Read in " + array.length + " lines.");

            Instant start = Instant.now();
            // bubblesort(list);
            insertionSort(array);
            Instant finish = Instant.now();
            long elapsed = (long) Duration.between(start, finish).toMillis();
            System.out.printf("FINAL LIST: %d Milliseconds\n", elapsed);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    
    public static void insertionSort(int[] array) {
        double comparisons = 0;
        double swaps = 0;
        
        int i, j;
        for (i = 0; i < array.length; i++) {
            int v = array[i]; j = i;
            while (j > 0 && array[j - 1] > v) {
                comparisons++;
                swaps++;
                array[j] = array[j - 1];
                j--;
            }
            array[j] = v;
            swaps++;
        }
        
        System.out.println("Total swaps: " + swaps + "\nTotal comparisons: " + comparisons);
    }
}
