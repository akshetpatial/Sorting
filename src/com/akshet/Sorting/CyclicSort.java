package com.akshet.Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class CyclicSort {

    //In this Sorting technique the range of the value should be form 1 to N or 0 to N.
    // Best Case Time complexity is O(N)
    // Worst Case Time complexity is O(N)
    // Space complexity is O(1)
    public static int[] CyclicSorting(int[] array){

        int start=0;
        int end=array.length-1;
        while(start<=end){
            /* This is one logic
            if(array[start]!=start+1)
                SwapifNotEqual(start,array[start]-1,array);
             */
        //This is another way of doing it in a better way
            int current= array[start];
            if(array[start]!=array[current-1]) {
                SwapifNotEqual(start,array[start]-1,array);
            }
            else
                start++;
        }
        return array;
    }

    public static int[] SwapifNotEqual(int from, int to, int[] array){
        int temp = array[from];
        array[from]=array[to];
        array[to]=temp;
        return array;
    }

    public static void main(String[] args) {

        System.out.println("Enter the Size of the array: ");
        Scanner scan= new Scanner(System.in);
        int size=scan.nextInt();

        System.out.println("Enter the Elements of the un-sorted array: ");
        System.out.println("Please Note here for Cyclic Sort Please enter element between 1 to N only: ");
        int[] array=new int[size];
        // 5 4 1 3 2     10 1 2 6 8 9 7 5 4 3
        for(int i=0;i<size;i++){
            array[i]=scan.nextInt();
        }

        System.out.println("Entered un-sorted array is: ");
        for(int element : array){
            System.out.print(element+" ");
        }

        int[] SArray= CyclicSorting(array);

        System.out.println("\nSorted Array after Cyclic Sort is: "+ Arrays.toString(SArray));

    }
}
