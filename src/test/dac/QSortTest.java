package dac;

import com.ytf.ds.dac.QSort;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Program: datastruct
 * @Description: 快排单测
 * @Author: yutianfang
 * @Date: 2019-07-30
 **/
public class QSortTest {
    private Comparable[] a = new Comparable[]{1,10,7,9,8};
    private Comparable[] b = new Comparable[]{1,2,3,4,5};

    @Test
    public void sort(){
        QSort.qsort(a, 0, a.length - 1);
        Assert.assertEquals(0, a[0].compareTo(1));
        Assert.assertEquals(0, a[1].compareTo(7));
        Assert.assertEquals(0, a[2].compareTo(8));
        Assert.assertEquals(0, a[3].compareTo(9));
        Assert.assertEquals(0, a[4].compareTo(10));


        QSort.qsort(b, 0, b.length - 1);
        Assert.assertEquals(0, b[0].compareTo(1));
        Assert.assertEquals(0, b[1].compareTo(2));
        Assert.assertEquals(0, b[2].compareTo(3));
        Assert.assertEquals(0, b[3].compareTo(4));
        Assert.assertEquals(0, b[4].compareTo(5));
    }


    @Test
    public void topK(){
        Comparable<Integer>[] a = new Comparable[]{1, 10, 7, 9, 8};

        Comparable result = QSort.topK(a, 3);
        Assert.assertEquals(9, result);

        Comparable<Integer>[] b = new Comparable[]{1, 2, 3, 4, 5};
        result = QSort.topK(b, 2);
        Assert.assertEquals(3, result);
    }
}
