import java.util.Scanner;
import java.util.Arrays;

/**
This program measures how long it takes to sort an
array of a user-specified size with the selection
sort algorithm.
 */
public class SearchTester
{  
    public static void main(String[] args)
    {  
        Scanner in = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = in.nextInt();

        // Construct random array
        int[] a = ArrayUtil.randomIntArray(n, 100);
        MergeSorter.sort(a);  //sort the array

        if (n <= 20)
            System.out.println(Arrays.toString(a)); 

        System.out.print("Enter number to search for: ");
        int num = in.nextInt();
        
        
        // Use stopwatch to time selection sort
        StopWatch timer = new StopWatch();

        timer.start();
        //int index = LinearSearcher.search(a, num);
        int index = BinarySearcher.search(a, num);
        timer.stop();

        System.out.println(num + " found at index: " + index);
        System.out.println("Elapsed time: " 
            + timer.getElapsedTime() + " nanoseconds");
            
        if (n <= 20)
            System.out.println(Arrays.toString(a)); //print sorted array
    }
}