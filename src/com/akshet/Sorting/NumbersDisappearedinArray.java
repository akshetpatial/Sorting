package com.akshet.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NumbersDisappearedinArray {
//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

        public List<Integer> findDisappearedNumbers(int[] nums) {

            List<Integer> list = new ArrayList<Integer>();

            //This Solution exceeds the time limit
       /*
        //Sorting the array
        Arrays.sort(nums);

        //System.out.println(Arrays.toString(nums));

       List<Integer> templist = new ArrayList<Integer>();
       int start=1;
       int end=nums.length-1;

        while(start<=end){
            if(nums[start]!=nums[start-1])
                templist.add(nums[start-1]);

            start++;
        }
        //addindg the last number
        templist.add(nums[end]);

        List<Integer> alllist= new ArrayList<Integer>();

        for(int i=0;i<=end;i++){
            alllist.add(i+1);
        }

        //System.out.println(alllist);

// use to Remove the common elements from the list
    alllist.removeAll(templist);


        //System.out.println(alllist);
        return alllist;
        */


            //This Solution works Best Use Cyclic Sort whenever there is a range given 0 to N or 1 to N

            int start=0;
            int end=nums.length-1;

            while(start<=end){
                int current = nums[start];
                if(nums[start]!=nums[current-1])
                    swaptheNumber(nums, start, current-1);
                else
                   start++;
            }

            System.out.println("\narray after sorting: " + Arrays.toString(nums));
            for(int i=0;i<nums.length;i++){
                if(nums[i]!=i+1)
                    list.add(i+1);
            }
            return list;
    }

    public static int[] swaptheNumber(int[] array, int from, int to){
            int temp= array[from];
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
        // 4 3 2 7 8 2 3 1    1 1   1 1 2 2
        for(int i=0;i<size;i++){
            array[i]=scan.nextInt();
        }

        System.out.println("Entered un-sorted array is: ");
        for(int element : array){
            System.out.print(element+" ");
        }

        // Non Static call so making an object
        NumbersDisappearedinArray NDArray = new NumbersDisappearedinArray();
        List<Integer> DNum= NDArray.findDisappearedNumbers(array);

        System.out.println("Missing Number is: "+ DNum);
    }

}
