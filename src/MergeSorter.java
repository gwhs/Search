import java.util.Arrays;
/**
 * Write a description of class MergeSorter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MergeSorter
{
    /**
    Merges two sorted arrays into an array
    @param first the first sorted array
    @param second the second sorted array
    @param a the array into which to merge first and second

    Precondition a.length = first.length + second.length
     */
    public static void merge(int[] first, int[] second, int[] a)
    {
        // to do
        int fIndex = 0;
        int sIndex = 0;

        for (int i = 0; i < a.length; i++)
        {
            if (sIndex < second.length && fIndex < first.length)
            {
                if (second[sIndex] < first[fIndex])
                {
                    a[i] = second[sIndex];
                    sIndex++;
                }
                else
                {
                    a[i] = first[fIndex];
                    fIndex++;
                }
            }
            else if (sIndex < second.length)
            {
                a[i] = second[sIndex];
                sIndex++;
            }
            else
            {
                a[i] = first[fIndex];
                fIndex++;
            }

        }
    }

    /**
     * Sorts the array in ascending (low to high) order
     * using the Merge Sort
     */
    public static void sort(int[] a)
    {
        //to do
        if (a.length <= 1)
            return;

        int[] first = new int[a.length/2];
        int[] second = new int[a.length - a.length/2];

        for (int i = 0; i < first.length; i++)
        {
            first[i] = a[i];
        }
        for (int i = 0; i < second.length; i++)
        {
            second[i] = a[i + first.length];
        }

        sort(first);
        sort(second);
        merge(first,second,a);
    }

    public static void mergeTester()
    {
        int[] first = {2,3,6,7,22,44};
        int[] second = {4,5,9,10};
        int[] aMerge = new int[first.length + second.length];
        MergeSorter.merge(first,second,aMerge);
        System.out.println("first: " + Arrays.toString(first));
        System.out.println("second: " + Arrays.toString(second));
        System.out.println("merged: " + Arrays.toString(aMerge));
    }
}
