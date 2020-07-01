package sort;

/**
 * 冒泡排序（稳定）
 *
 * 平均时间复杂度 O(n2)
 * 最好时间复杂度 O(n2)
 * 最坏时间复杂度 O(n2)
 *
 * 优化后的最好时间复杂度 O(n)
 *
 * @author ：隋亮亮
 * @since ：2020/6/20 23:17
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = new int[] { 6, 5, 2, 7, 3, 9, 8, 4, 10, 1};

//        sort1(a);
        sort2(a);

        for (int i : a) {
            System.out.println(i);
        }
    }

    /**
     * 优化前
     * @param n
     */
    public static void sort1(int[] n) {
        for (int i = 0; i < n.length - 1; i++) {
            for (int j = 0; j < n.length - i - 1; j++) {
                if(n[j] > n[j + 1]) QuickSort.swap(n, j, j + 1);
            }
        }
    }

    /**
     * 优化后
     * @param n
     */
    public static void sort2(int[] n) {
        boolean changeFlag = true;
        for (int i = 0; i < n.length - 1 && changeFlag; i++) {
            changeFlag = false;
            for (int j = 0; j < n.length - i - 1 ; j++) {
                if(n[j] > n[j + 1]) {
                    changeFlag = true;
                    QuickSort.swap(n, j, j + 1);
                }
            }
        }
    }
}
