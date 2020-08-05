package test.sort;

import sort.QuickSort;

/**
 * 平均时间复杂度 O(nlogn)
 * <p>
 * 最好时间复杂度 O(nlogn)
 * <p>
 * 最坏时间复杂度 O(n^2)
 * <p>
 * 空间复杂度O(1)
 * <p>
 * 不稳定
 *
 * @author ：隋亮亮
 * @since ：2020/8/5 21:12
 */
public class QuickSortTestIII {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 5, 9, 6, 4, 8, 7, 0};
        sort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void sort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partition = partition(arr, begin, end);

            sort(arr, begin, partition - 1);
            sort(arr, partition + 1, end);
        }
    }

    public static int partition(int[] arr, int left, int end) {
        int i = left;
        int j = end;
        int tmp = arr[left];

        while (i < j) {
            while (i < j && arr[j] >= tmp) j--;
            while (i < j && arr[i] <= tmp) i++;

            QuickSort.swap(arr, i, j);
        }

        QuickSort.swap(arr, i, left);

        return i;
    }
}
