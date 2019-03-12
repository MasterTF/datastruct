package com.ytf.ds.dac;

import java.util.Arrays;

/**
 * @Program: datastruct
 * @Description: 归并排序
 * @Author: yutianfang
 * @Date: 18/5/20星期日
 **/
public class MergeSort {

    public static void main(String[] args) {
        int[] a = new int[]{1, 10, 7, 9, 8};
        int[] b = new int[]{1, 2, 3, 4, 5};

        int[] aux = new int[a.length];

        mergeSort(a, aux, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

        //sorted = b;
        mergeSort(b, aux, 0, b.length - 1);
        System.out.println(Arrays.toString(b));
    }

    public static void mergeSort(int[] a, int[] aux, int low, int high) {
        if (low >= high) return;

        int mid = (low + high) / 2;
        // 左边有序
        mergeSort(a, aux, low, mid);
        // 右边有序
        mergeSort(a, aux, mid + 1, high);
        // 合并
        merge(a, aux, low, mid, high);
    }

    public static void merge(int[] a, int[] aux, int low, int mid, int high) {
        // copy
        for(int k = low; k <= high; k++){
            aux[k] = a[k];
        }

        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            // 左边复制完
            if (i > mid)                a[k] = aux[j++];
            // 右边复制完
            else if (j > high)          a[k] = aux[i++];
            // 未复制完
            else if (aux[j] < aux[i])        a[k] = aux[j++];
            else                        a[k] = aux[i++];
        }
    }
}
