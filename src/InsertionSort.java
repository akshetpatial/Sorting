import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {

    // Best Case Time complexity is O(N)
    // Worst Case Time complexity is O(N^2)
    // Space complexity is O(1)
    public static int[] InsertionSorting(int[] array){
        int outerloop=0;
        int innerloop=1;
        int endouterloop=array.length-2;
        while(outerloop<=endouterloop){
                innerloop=outerloop+1;
            while(innerloop>0){
                if(array[innerloop]<array[innerloop-1])
                    SwapifSmaller(innerloop,innerloop-1,array);
                else
                    break;
                innerloop--;
            }
            outerloop++;
        }
        return array;
    }

    public static int[] SwapifSmaller(int innerloop, int outerloop, int[] array){
        int temp=array[innerloop];
        array[innerloop]=array[outerloop];
        array[outerloop]=temp;
        return array;
    }

    public static void main(String[] args) {
        System.out.println("Enter the Size of the array: ");
        Scanner scan= new Scanner(System.in);
        int size=scan.nextInt();

        System.out.println("Enter the Elements of the un-sorted array: ");
        int[] array=new int[size];
        // 1 2 8 3 4 9    5 3 4 1 2
        for(int i=0;i<size;i++){
            array[i]=scan.nextInt();
        }

        System.out.println("Entered un-sorted array is: ");
        for(int element : array){
            System.out.print(element+" ");
        }

        int[] SArray= InsertionSorting(array);

        System.out.println("\nSorted Array after Insertion Sort is: "+ Arrays.toString(SArray));
    }
}
