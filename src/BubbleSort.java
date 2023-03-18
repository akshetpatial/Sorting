import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {


    public static int[] BubbleSorting(int[] array){

        int outloop=0;
        int innerloop=1;
        int count;
        while(outloop<array.length ) {
                count=0;
                innerloop=1;
            while (innerloop < array.length-outloop) {
                if (array[innerloop] < array[innerloop - 1]) {
                    count++;
                   SwapifSmaller(innerloop, innerloop - 1,array);
                } else
                    innerloop++;
            }
            if(count==0)
                return array;
            else
                outloop++;
        }
        return array;
    }

    public static int[] SwapifSmaller(int current, int previous, int[] array){
        int temp = array[current];
        array[current]=array[previous];
        array[previous]=temp;
        return array;
    }

    public static void main(String[] args){
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

        int[] SArray= BubbleSorting(array);

        System.out.println("\nSorted Array after Bubble sort is: "+ Arrays.toString(SArray));
    }
}
