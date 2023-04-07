import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {

    // In Quick Sort we try to put pivot in the right position where element less then the pivot will be in left side and element greater then
    // Pivot will be on right side


    // This was just for test purpose

    /*public static void QuickSorting(int[] array, int start, int end , int pivot, int pivotpos) {

        // Putting pivot in the right place in worst case will make N comparisons

        int temp_start=start;
        int temp_end= end;

        while(temp_start<temp_end) {
            if (array[temp_start] > pivot && array[temp_end] < pivot) {
                swap(array, temp_start, temp_end);

            } else {
                if (array[temp_end] < pivot) {
                    swap(array, pivotpos, temp_end);
                    pivotpos=temp_end;
                }
                if (array[temp_start] > pivot) {
                    swap(array, temp_start, pivotpos);
                    pivotpos=temp_start;
                }
            }
            temp_start++;
            temp_end--;
        }

        if(end-start==0 || end<0)
            return;

        QuickSorting(array,0,pivotpos-1,pivot,pivotpos);
        QuickSorting(array,pivotpos+1,array.length-1,pivot,pivotpos);
    }*/

    // Pivot would be the element not the index as the elements swaps hence the index would be changed so we need to keep the track of the
    // element rather than the indices
    public static void QuickSorting(int[] array, int low, int high) {

        if(low>=high)
            return;


        int end = high;
        int start = low;
        int mid = start + ( end-start)/2;
        int pivot = array[mid];

        while(start<=end) {
            while(array[start] < pivot)
                start++;

            while (array[end] > pivot)
                end--;
            if(start<=end) {
                swap(array, start, end);
                start++;
                end--;
            }
        }

        QuickSorting(array,low,end);
        QuickSorting(array,start,high);

    }

    public static void swap(int[] array, int from, int to){
        int temp = array[from];
        array[from]=array[to];
        array[to]=temp;
    }

    public static void main(String[] args) {
        System.out.println("Enter the Size of the array: ");
        Scanner scan= new Scanner(System.in);
        int size=scan.nextInt();

        System.out.println("Enter the Elements of the un-sorted array: ");
        int[] array=new int[size];
        // 1 2 8 3 4 9   8 3 4 12 5 6 2 7   5 4 3 2 1    10 80 30 90 40 50 70
        for(int i=0;i<size;i++){
            array[i]=scan.nextInt();
        }

        System.out.println("Entered un-sorted array is: ");
        for(int element : array){
            System.out.print(element+" ");
        }

        int start=0;
        int end= array.length-1;
        QuickSorting(array,start,end);

        System.out.println("\nSorted Array after Quick Sort is: "+ Arrays.toString(array));

    }

}
