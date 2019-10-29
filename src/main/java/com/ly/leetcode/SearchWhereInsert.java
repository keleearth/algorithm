package com.ly.leetcode;

import java.util.Arrays;

public class SearchWhereInsert {
    /**
     * 给定一个排序数组和一个目标值，返回目标值所在排序数组中的位置，如果
     * 目标值不存在，返回应该排序插入的位置，可以假设数组中无重复元素
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,7};
        //System.out.println(searchWhereInsert(arr,5));
        //System.out.println(searchWhereInsert(arr,2));
        //System.out.println(searchWhereInsert(arr,8));
        //System.out.println(searchWhereInsert(arr,0));
        System.out.println(binarySearch(arr,5));
        System.out.println(binarySearch(arr,2));
        System.out.println(binarySearch(arr,8));
        System.out.println(binarySearch(arr,0));
    }

    public static int searchWhereInsert(int[] arr,int targetNum){
        int offset = 0;
        for(; offset < arr.length; offset++){
            if(arr[offset] >= targetNum){
                return offset;
            }
        }
        return offset;
    }

    /**
     * 二分查找
     * @param arr
     * @param targetNum
     * @return
     */
    public static int binarySearch(int[]arr,int targetNum){
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while(left <= right){
            //mid = (left+right)/2;
            //mid = (left+right)>>>1;
            mid = left + (right - left)/2;
            if(arr[mid] < targetNum){
                left = mid + 1;
            }else if(arr[mid] > targetNum){
                right = mid - 1;
            }else{
                return mid;
            }
        }
        return left;
    }
}
