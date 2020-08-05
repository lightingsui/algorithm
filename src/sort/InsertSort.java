package sort;

/**
 * 直接插入排序
 * <p>
 *     平均时间复杂度 O(n ^ 2)
 * <p>
 *     最好时间复杂度 O(n)
 * <p>
 *     最坏时间复杂度 O(n ^ 2)
 * <p>
 *     空间复杂度 O(1)
 * <p>
 *     不稳定
 *
 * @author ：隋亮亮
 * @since ：2020/8/5 22:35
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] a = new int[]{6, 5, 2, 7, 3, 9, 8, 4, 10, 1};

        sort1(a);

        for (int i : a) {
            System.out.println(i);
        }
    }

    private static void sort1(int[] arr) {
        int j = 0;
        int k = 0;

        for (int i = 1; i < arr.length; i++) {

            for (j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    break;
                }
            }

            int tmp = arr[i];

            for(k = i - 1; k > j; k--) {
                arr[k + 1] = arr[k];
            }

            arr[k + 1] = tmp;
        }
    }
}
