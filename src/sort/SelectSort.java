package sort;

/**
 * 选择排序（不稳定）
 *
 * 平均时间复杂度 O(n2)
 * 最坏时间复杂度 O(n2)
 * 最好时间复杂度 O(n)
 *
 * @author ：隋亮亮
 * @since ：2020/6/20 23:51
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] a = new int[] { 6, 5, 2, 7, 3, 9, 8, 4, 10, 1};

//        sort1(a);
        sort(a);

        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void sort(int[] n) {
        for (int i = 0; i < n.length - 1; i++) {
            int k = i;
            for (int j = i + 1; j < n.length; j++) {
                if(n[k] > n[j]) k = j;
            }
            if(i != k) {
                n[i] ^= n[k];
                n[k] ^= n[i];
                n[i] ^= n[k];
            }
        }
    }
}
