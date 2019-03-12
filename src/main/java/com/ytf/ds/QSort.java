package com.ytf.ds;

import java.util.Arrays;

/**
 * @Program: datastruct
 * @Description: 快排
 * @Author: yutianfang
 * @Date: 19/2/21星期四
 **/
public class QSort {
    public static void main(String[] args){
        int[] a = new int[]{1,10,7,9,8};
        int[] b = new int[]{1,2,3,4,5};

        int[] sorted = a;
        qsort(sorted,0, sorted.length - 1);
        System.out.println(Arrays.toString(a));

        sorted = b;
        qsort(sorted,0, sorted.length - 1);
        System.out.println(Arrays.toString(b));
    }

    private static void qsort(int[] array, int low, int high){
        if(low >= high) return;
        // 选取中值
        int position = partition(array, low, high);
        // 左边有序
        qsort(array, low, position - 1);
        // 右边
        qsort(array, position + 1, high);
    }

    private static int partition(int[] array, int low, int high){
        int pivot = array[low];

        int left = low, right = high + 1;

        while(true){
            while(array[++left] < pivot && left != high);

            while(array[--right] > pivot && right != low);

            if(left >= right) break;

            swap(array, left, right);
        }
        swap(array, low, right);
        return right;
    }

    private static void swap(int[] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
