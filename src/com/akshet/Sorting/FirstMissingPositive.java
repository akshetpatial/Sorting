package com.akshet.Sorting;


import java.util.Scanner;

public class FirstMissingPositive {
//    https://leetcode.com/problems/first-missing-positive/


   //IMP:-  Always go for range 1 to N to find the missing number instead of 0 to N
        public static int MNumber(int[] nums){

            int start=0;
            int end=nums.length-1;

            while(start<=end){
                int current =nums[start];
                // Here checking nums[start]>0 and nums[start]<=end+1 should be before nums[start]!=nums[current-1] or else
                // it will check nums[start]!=nums[current-1] conditions first and will throw index out of bound error.
                if(nums[start]>0 && nums[start]<=end+1 && nums[start]!=nums[current-1] )
                    swap(nums, start, current-1);
                else
                    start++;

            }

            for(int i=0;i<nums.length;i++){
                if(nums[i]!=i+1)
                    return i+1;
            }
            return nums.length+1;
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
        //1 2 0    3 4 -1 1    7 8 9 11 12  1   2 1
        for(int i=0;i<size;i++){
            array[i]=scan.nextInt();
        }

        System.out.println("Entered un-sorted array is: ");
        for(int element : array){
            System.out.print(element+" ");
        }

        int MNum= MNumber(array);

        System.out.println("\nMissing Positive Number is: "+ MNum);
    }
}
