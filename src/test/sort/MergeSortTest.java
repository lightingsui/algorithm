package test.sort;

/**
 * @author ：隋亮亮
 * @since ：2020/6/28 18:25
 */
public class MergeSortTest {
    public static void main(String[] args) {
        int[] a = new int[]{7, 5, 6, 4};

//        sort1(a);
        mergeSort(a, 0, a.length - 1);

        for (int i : a) {
            System.out.println(i);
        }
    }

    private static void mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(a, left, mid);
            mergeSort(a, mid + 1, right);

            if(a[mid] <= a[mid + 1]) {
                return;
            }

            sort(a, left, mid, right);
        }
    }

    private static void sort(int[] a, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;

        int[] tmp = new int[right - left + 1];
        int flag = 0;


        while(i <= mid && j <= right) {
            if(a[i] <= a[j]) {
                tmp[flag++] = a[i++];
            } else {
                tmp[flag++] = a[j++];
            }
        }

        // 归并未归并的部分
        while(i <= mid) {
            tmp[flag++] = a[i++];
        }

        while(j <= right) {
            tmp[flag++] = a[j++];
        }

        flag = 0;
        // dump
        for (int k = left; k <= right; k++) {
            a[k] = tmp[flag++];
        }
    }


}
