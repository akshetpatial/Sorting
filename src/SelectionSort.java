import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {

    public static int[] SelectionSorting(int[] array){

        int outerloop=0;
        int innerloop=0;
        while(outerloop<array.length){
            int max=array[0];
            int maxPos=0;
            innerloop=0;
            while(innerloop<array.length-outerloop) {
                if (array[innerloop] > max) {
                    max = array[innerloop];
                    maxPos = innerloop;
                }
                else
                    innerloop++;
            }
                int targetPos= array.length-1-outerloop;
                SwapatPosition(maxPos,targetPos,array);
                outerloop++;
        }
        return array;
    }

    public static int[] SwapatPosition(int innerloop, int targetPos, int[] array){
        int temp=array[innerloop];
        array[innerloop]=array[targetPos];
        array[targetPos]=temp;
        return array;
    }

    public static void main(String[] args) {
        System.out.println("Enter the Size of the array: ");
        Scanner scan= new Scanner(System.in);
        int size=scan.nextInt();

        System.out.println("Enter the Elements of the un-sorted array: ");
        int[] array=new int[size];
        // 1 2 8 3 4 9
        for(int i=0;i<size;i++){
            array[i]=scan.nextInt();
        }

        System.out.println("Entered un-sorted array is: ");
        for(int element : array){
            System.out.print(element+" ");
        }

        int[] SArray= SelectionSorting(array);

        System.out.println("\nSorted Array after Bubble sort is: "+ Arrays.toString(SArray));
    }
}
