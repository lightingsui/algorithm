package test.sort;

import sort.QuickSort;

/**
 * 平均时间复杂度 O(n ^ 2)
 * <p>
 * 最好时间复杂度 O(n)
 * <p>
 * 最坏时间复杂度 O(n ^ 2)
 * <p>
 * 空间复杂度 O(1)
 * <p>
 * 不稳定
 *
 * @author ：隋亮亮
 * @since ：2020/8/5 22:57
 */
public class SelectSortTest {
    public static void main(String[] args) {
        int[] a = new int[] { 6, 5, 2, 7, 3, 9, 8, 4, 10, 1};

//        sort1(a);
        sort(a);

        for (int i : a) {
            System.out.println(i);
        }
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {

            int k = i;

            for (int j = i; j < arr.length; j++) {

                if(arr[k] > arr[j]) {
                    k = j;
                }
            }

            if( k != i ) {
                QuickSort.swap(arr, k, i);
            }
        }
    }
}
