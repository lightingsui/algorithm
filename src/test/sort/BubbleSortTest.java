package test.sort;

import sort.QuickSort;

/**
 * 平均时间复杂度 O(n ^ 2)
 * <p>
 * 最坏时间复杂度 O(n ^ 2)
 * <p>
 * 最好时间复杂度 O(n)
 * <p>
 *     空间复杂度 O(1)
 * <p>
 *     稳定
 *
 * @author ：隋亮亮
 * @since ：2020/8/5 22:26
 */
public class BubbleSortTest {
    public static void main(String[] args) {
        int[] a = new int[] { 6, 5, 2, 7, 3, 9, 8, 4, 10, 1};

//        sort1(a);
        sort2(a);

        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void sort2(int[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length - 1 && flag; i++) {
            flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    flag = true;
                    QuickSort.swap(arr, j , j + 1);
                }
            }
        }
    }
}
