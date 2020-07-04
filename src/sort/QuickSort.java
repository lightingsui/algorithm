package sort;

/**
 * 快排（不稳定）
 *
 * 平均时间复杂度 O(logn)
 * 最好时间复杂度 O(logn)  每次划分产生的区间大小都为 n / 2
 * 最坏时间复杂度 O(n2)
 *
 * @author ：隋亮亮
 * @since ：2020/6/20 23:17
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = new int[] { 6, 5, 2, 7, 3, 9, 8, 4, 10, 1};

        sort(a, 0, a.length - 1);

        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void sort(int[] n, int left, int right) {
        if(left < right) {
            int partition = partition(n, left, right);

            sort(n, left, partition - 1);
            sort(n,partition + 1, right);
        }
    }

    public static int partition(int[] n, int left, int right) {
        int p = left;

        while (left < right) {
            while(n[right] >= n[p] && left < right) right--;
            while(n[left] <= n[p] && left < right) left++;

            swap(n, left, right);
        }
        swap(n, left, p);

        return right;
    }

    public static void swap(int[] n, int l, int r) {
        /*n[l] = n[l] ^ n[r];
        n[r] = n[r] ^ n[l];
        n[l] = n[l] ^ n[r];*/

        int temp = n[l];
        n[l] = n[r];
        n[r] = temp;
    }
}
