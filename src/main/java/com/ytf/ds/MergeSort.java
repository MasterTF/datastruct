package com.ytf.ds;

import java.util.Arrays;

/**
 * @Program: datastruct
 * @Description: 归并排序
 * @Author: yutianfang
 * @Date: 19/3/6星期三
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

    public static void mergeSort(int[] origin, int[] extra, int low, int high){
        if(low >= high) return;
        int mid = (low + high) / 2;
        mergeSort(origin, extra, low, mid);
        mergeSort(origin, extra, mid + 1, high);
        merge(origin, extra, low, mid, high);
    }

    private static void merge(int[] origin, int[] ext, int low, int mid, int high){
        for(int i = low; i <= high; i++){
            ext[i] = origin[i];
        }

        int left = low,right = mid + 1;
        for(int i = low; i <= high; i++){
            if(left > mid)                      origin[i] = ext[right++];
            else if(right > high)               origin[i] = ext[left++];
            else if(ext[right] < ext[left])     origin[i] = ext[right++];
            else                                origin[i] = ext[left++];
        }
    }
}
