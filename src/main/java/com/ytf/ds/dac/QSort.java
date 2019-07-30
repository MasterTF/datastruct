package com.ytf.ds.dac;

/**
 * @Program: datastruct
 * @Description: 快排
 * @Author: yutianfang
 * @Date: 19/2/21星期四
 **/
public class QSort {

    public static void qsort(Comparable[] array, int low, int high){
        if(low >= high) return;
        // 选取中值
        int position = partition(array, low, high);
        // 左边有序
        qsort(array, low, position - 1);
        // 右边
        qsort(array, position + 1, high);
    }

    private static int partition(Comparable[] array, int low, int high){
        Comparable pivot = array[low];

        int left = low, right = high + 1;

        while(true){
            while(array[++left].compareTo(pivot) < 0 && left != high);

            while(array[--right].compareTo(pivot) > 0 && right != low);

            if(left >= right) break;

            swap(array, left, right);
        }
        swap(array, low, right);
        return right;
    }

    private static void swap(Comparable[] array, int left, int right){
        Comparable temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static Comparable topK(Comparable[] array, int k){
        int left = 0, right = array.length - 1;
        while(left < right){
            int position = partition(array, left, right);
            if(position > k)        right = position - 1;
            else if(position < k)   left = position + 1;
            else                    return array[k];
        }
        return array[k];
    }
}
