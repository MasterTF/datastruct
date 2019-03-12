package com.ytf.ds.dac;

import java.util.Arrays;

/**
 * @Program: datastruct
 * @Description: 快排
 * @Author: yutianfang
 * @Date: 19/2/7星期四
 **/
public class QuickSort {

    public static void main(String[] args){
        int[] a = new int[]{1,10,7,9,8};
        int[] b = new int[]{1,2,3,4,5};

        int[] sorted = a;
        qsort(sorted,0, sorted.length - 1);
        System.out.println(Arrays.toString(a));

        sorted = b;
        qsort(sorted,0, sorted.length - 1);
        System.out.println(Arrays.toString(b));


        a = new int[]{1,10,7,9,8};
        b = new int[]{1,2,3,4,5};
        System.out.println("top3: " + topK(a, 3));
        System.out.println("top3: " + topK(b, 3));
    }

    public static void qsort(int[] array, int low, int high) {
        if (low >= high) return;

        int position = partition(array, low, high);

        qsort(array, low, position - 1);
        qsort(array, position + 1, high);
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[low];

        int left = low, right = high + 1;

        while (true) {
            // 从左找大于pivot
            while (array[++left] < pivot && left < high);

            // 从右找小于pivot
            while ( pivot < array[--right] && right > low);
            
            if(left >= right) break;

            // 交换位置
            swap(array, left ,right);
        }

        // 找到基值位置
        swap(array, low, right);
        return  right;
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static int topK(int[] array, int k){
        int left = 0, right = array.length - 1;

        while(left < right){
            int position = partition(array, left, right);
            if(position == k) return array[position];
            else if (k > position) left = position + 1;
            else right = position - 1;
        }

        return array[k];
    }
}
