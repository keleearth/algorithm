package com.ly.sort;

import com.ly.util.PrintUtil;

/**
 * 插入排序
 */
public class InsertSort {

    /**
     * 插入排序
     * 插入排序的思想就是，将一个无序的数组插入一个有序的数组中完成排序
     * 关键就是构建一个有序数组
     * 就将第一个元素看成是有序数组，剩下的元素为无序
     * 插入时，先将要插入的元素从原数组中移除
     * 这样原数组就多了一个空位，方便元素插入
     * 将代插入元素与有序数组比较，如果比有序数组当前值小，就将元素后移
     * 比当前值大，则当前位置就是要插入的位置，退出循环
     * 将移除的元素插入到此位置
     * 这样循环过后，数组就是有序的了
     * @param arr
     */
    public static void insertSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i = 1 ; i < arr.length; i++){
            //先空出一个位置，方便元素插入
            int key = arr[i];
            int j = i -1;
            //遍历有序数组，找到被移除的元素应该放的位置
            while(j >= 0 && key < arr[j]){
                arr[j + 1] = arr[j];
                j--;
            }
            //将空出的位置填上刚才移除的元素
            arr[j +1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12,3,4,64,34,5,78,1,4,67,5};
        int[] arr1 = new int[]{1};
        int[] arr2 = new int[]{8,7,6,5,4,3,2,1};
        int[] arr3 = new int[]{};
        int[] arr4 = null;
        insertSort(arr);
        insertSort(arr1);
        insertSort(arr2);
        insertSort(arr3);
        insertSort(arr4);
        System.out.println(PrintUtil.ptint(arr));
        System.out.println(PrintUtil.ptint(arr1));
        System.out.println(PrintUtil.ptint(arr2));
        System.out.println(PrintUtil.ptint(arr3));
        System.out.println(PrintUtil.ptint(arr4));
    }
}
