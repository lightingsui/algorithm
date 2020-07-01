package test.sort;

import java.util.Collections;
import java.util.Comparator;

/**
 * 快速排序测试
 *
 * @author ：隋亮亮
 * @since ：2020/6/23 0:22
 */
public class QuickSortTest {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 5, 9, 6, 4, 8, 7, 0};
        sort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.println(i);
        }

        Collections.sort(null, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
    }

    public static void sort(int[] arr, int left, int  right) {
        if(left < right) {
            int partition = partition(arr, left, right);

            sort(arr, left, partition - 1);
            sort(arr, partition + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int tmp = arr[left];

        for (int i = left; i <= right; i++) {
            while(l < r && arr[r] >= tmp) r--;
            while(l < r && arr[l] <= tmp) l++;

            swap(arr, l, r);
        }

        swap(arr, l, left);

        return l;
    }

    public static void swap( int[] arr, int first, int last) {
        int tmp = arr[first];
        arr[first] = arr[last];
        arr[last] = tmp;
    }
}
