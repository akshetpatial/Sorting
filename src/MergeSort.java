import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {


    // TIme complexity is O(N*log2N)
    // Space complexity is O(N)
    public static int[] MergeSorting(int[] array){

        // Use the copy of Range function to copy those elements which are required not the whole array and return the array
        // when only one element is remaining
        // This is not in-place Merge Sort as we are making a new object every time
        if(array.length==1)
            return array;


        // Here we are using the below formula to find the mid as ever time a new Array is passed so we just need the half of the length
        // we can not use the start + (end-start)/2 because a new array is passed not the original one.
        int mid = array.length/2;

        // Here Start is inclusive but end is not inclusive means end index here is not included. (end-1 is included)
        int[] leftArray = MergeSorting(Arrays.copyOfRange(array,0,mid));
        int[] rightArray= MergeSorting(Arrays.copyOfRange(array,mid,array.length));

        return merge(leftArray,rightArray);
    }

    public static int[] merge(int[] first, int[] second){

        int[] finalArray= new int[first.length + second.length];
        // for First Array
        int i=0;
        // for Second Array
        int j=0;
        // for Final Array
        int k=0;

        while(i <first.length && j < second.length)
        {
            if(first[i]<second[j]){
                finalArray[k]=first[i];
                i++;
            }else{
                finalArray[k]=second[j];
                j++;
            }
                k++;
        }

        // Now as from above it may be possible that one array is complete hence remaining array will be entered as it is
        while(i<first.length){
            finalArray[k]=first[i];
            k++;
            i++;
        }

        while(j<second.length){
            finalArray[k]=second[j];
            k++;
            j++;
        }

        return finalArray;
    }

    public static void MergeSortingInPlace(int[] array, int start, int end){

        if(end - start == 0)
            return;

        int mid= start + ( end-start)/2;

        MergeSortingInPlace(array, start,mid);
        //System.out.println("array: "+ Arrays.toString(array)+" Start:  "+start+" End: "+ end+ " Mid: "+mid);
        MergeSortingInPlace(array,mid+1,end);
        //System.out.println("array: "+ Arrays.toString(array)+" Start:  "+start+" End: "+ end+ " Mid: "+mid);
        mergeInPlace(array,start,mid,end);
    }

    public static void  mergeInPlace(int[] array, int start, int mid , int end) {

        int[] new_Array = new int[end - start+1];

        int i = start;
        int j = mid+1;
        int k = 0;

        while (i <= mid && j <= end){
            if (array[i] < array[j]) {
                new_Array[k] = array[i];
                i++;
            } else {
                new_Array[k] = array[j];
                j++;
            }
        k++;
    }
        while(i<=mid){
            new_Array[k]=array[i];
            k++;
            i++;
        }

        while(j<=end){
            new_Array[k]=array[j];
            k++;
            j++;
        }

        // Now saving it to the same array
        int t=start;
        for(int c =0 ;c<new_Array.length;c++){
            array[t]=new_Array[c];
            t++;
        }
    }


    public static void main(String[] args) {
        System.out.println("Enter the Size of the array: ");
        Scanner scan= new Scanner(System.in);
        int size=scan.nextInt();

        System.out.println("Enter the Elements of the un-sorted array: ");
        int[] array=new int[size];
        // 1 2 8 3 4 9   8 3 4 12 5 6 2 7   5 4 3 2 1
        for(int i=0;i<size;i++){
            array[i]=scan.nextInt();
        }

        System.out.println("Entered un-sorted array is: ");
        for(int element : array){
            System.out.print(element+" ");
        }

        // Original Array is not modified that is array is still the input array the Sorted array is in SArray
        int[] SArray= MergeSorting(array);

        System.out.println("\nSorted Array after Merge Sort is: "+ Arrays.toString(SArray));

        // In Place Merge Sort
        System.out.println("In Place Merge Sort: ");
        int start=0;
        int end=array.length-1;
        MergeSortingInPlace(array,start,end);

        System.out.println("Sorted Array after Merge Sort is: "+ Arrays.toString(array));

    }
}
