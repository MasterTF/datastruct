package com.ytf.ds.dac;

/**
 * @Program: datastruct
 * @Description: 归并排序
 * @Author: yutianfang
 * @Date: 19/3/6星期三
 **/
public class MergeSort {
    public static void mergeSort(Comparable[] origin, Comparable[] extra, int low, int high){
        if(low >= high) return;
        int mid = (low + high) / 2;
        mergeSort(origin, extra, low, mid);
        mergeSort(origin, extra, mid + 1, high);
        merge(origin, extra, low, mid, high);
    }

    private static void merge(Comparable[] origin, Comparable[] ext, int low, int mid, int high){
        for(int i = low; i <= high; i++){
            ext[i] = origin[i];
        }

        int left = low,right = mid + 1;
        for(int i = low; i <= high; i++){
            if(left > mid)                                      origin[i] = ext[right++];
            else if(right > high)                               origin[i] = ext[left++];
            else if(ext[right].compareTo(ext[left]) < 0)        origin[i] = ext[right++];
            else                                                origin[i] = ext[left++];
        }
    }
}
