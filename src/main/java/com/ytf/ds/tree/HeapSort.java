package com.ytf.ds.tree;

import java.util.Arrays;

/**
 * @Program: datastruct
 * @Description: 堆排序
 * @Author: yutianfang
 * @Date: 19/2/21星期四
 **/
public class HeapSort {
    public int size;
    public int capacity;

    public static void main(String[] args){
        int[] a = new int[]{0, 10, 7, 9, 8};
        int[] b = new int[]{1, 2, 3, 4, 5};

        new HeapSort().sort(a);
        System.out.println(Arrays.toString(a));

        //sorted = b;
        /*new HeapSort().sort(b);
        System.out.println(Arrays.toString(b));*/
    }

    /**
     * 将数组初始化为最大堆
     * @param array
     */
    public void sort(int[] array){
        size = array.length - 1;
        for(int i = size / 2; i >= 1; i--){
            sink(array, i);
        }

        while(size >= 1){
            swap(array, size--, 1);
            sink(array, 1);
        }

    }

    private void sink(int[] array, int k){
        while(2*k <= size){
            int j = 2*k;
            // 选较小的
            if(j < size && array[j] > array[j + 1]) j++;

            if(array[k] <= array[j]) break;

            swap(array, k ,j);

            k = j;
        }
    }

    public void swim(int[] array, int k){
        while(k > 1 && array[k] < array[k / 2]) {
            swap(array, k / 2, k);
            k /= 2;
        }
    }

    private static void swap(int[] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
