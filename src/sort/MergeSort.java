package sort;

/**
 * 二路归并排序 (稳定)
 *
 * 最好时间复杂度 O(logn)
 * 最坏时间复杂度 O(logn)
 * 平均时间复杂度 O(logn)
 *
 * 空间复杂度 O(n)
 *
 * @author ：隋亮亮
 * @since ：2020/6/26 8:53
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a = new int[] { 7,5,6,4};

//        sort1(a);
        mergeSort(a, 0, a.length - 1);

        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            if(arr[mid] <= arr[mid + 1]) {
                return;
            }

            sort(arr, left, mid, right);
        }
    }

    public static void sort(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        // 将两边小的数放入到新数组
        while(i <= mid && j <= right) {
            if(arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }

        // 将左边剩余的数放入新数组
        while(i <= mid) {
            tmp[k++] = arr[i++];
        }

        // 将右边剩余的数放入新数组
        while(j <= right) {
            tmp[k++] = arr[j++];
        }

        // 替换原数组
        k = 0;
        while(k < tmp.length) {
            arr[left + k] = tmp[k++];
        }
    }
}
