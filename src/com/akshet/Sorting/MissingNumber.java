package com.akshet.Sorting;

import java.util.Scanner;

public class MissingNumber {
//    https://leetcode.com/problems/missing-number/

    public static int MNumber(int[] nums){
/* one way
        int givenSum=0;

        for(int i=0;i<nums.length;i++){
            givenSum+=nums[i];
        }
   int totalSum=0;

         for(int i=0;i<=nums.length;i++){
             totalSum+=i;
         }
     return totalSum-givenSum;

*/

        // other way

        int start=0;
        int end=nums.length-1;

        while(start<=end){
            if(nums[start]!=start && nums[start]<=end){
                swap(nums,start,nums[start]);
            }else
            start++;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i)
                return i;
        }
        return nums.length;
    }

    public static int[] swap(int[] array, int from, int to){

        int temp=array[from];
        array[from]=array[to];
        array[to]=temp;
        return array;
    }


    public static void main(String[] args) {
        System.out.println("Enter the Size of the array: ");
        Scanner scan= new Scanner(System.in);
        int size=scan.nextInt();

        System.out.println("Enter the Elements of the un-sorted array: ");
        int[] array=new int[size];
        // 3 0 1    0 1     9 6 4 2 3 5 7 0 1   1 2
        for(int i=0;i<size;i++){
            array[i]=scan.nextInt();
        }

        System.out.println("Entered un-sorted array is: ");
        for(int element : array){
            System.out.print(element+" ");
        }

        int MNum= MNumber(array);

        System.out.println("\nMissing Number is: "+ MNum);
    }
}
