package com.mygitgor;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {

    }



    public static boolean hasPairWithSumHashSet(int[] nums, int targetSum) {
       Set<Integer> set = new HashSet<>();
       for(int num : nums){
           int complement = targetSum - num;//число, которое в сумме с num даёт targetSum
           if(set.contains(complement)){
               System.out.println("sum for searched "+complement+" + "+num+" = "+targetSum);
               return true;
           }
           set.add(num);
       }
       return false;
    }

    public static int midlElement(int[] elements){

        Arrays.sort(elements);
        int idx =  elements.length / 2;
        return elements[idx];

    }

    public static int maxCounter(int[] counts){
        int maxCount = 0;
        int current = 0;
        for(int count : counts){
            if(count > 0){
                current += 1;
                if(current > maxCount){
                    maxCount = current;
                }

            }else{
                current = 0;
            }
        }

        return maxCount;
    }

    public static boolean isAnagram(String a, String b){
        if(a.length() != b.length()){
            return false;
        }

        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

        Arrays.sort(aChars);
        Arrays.sort(bChars);

        return Arrays.equals(aChars, bChars);
    }



}