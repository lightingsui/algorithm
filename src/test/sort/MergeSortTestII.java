package test.sort;

/**
 * 平均时间复杂度 O(nlogn)
 * <p>
 * 平均时间复杂度 O(nlogn)
 * <p>
 * 平均时间复杂度 O(nlogn)
 * <p>
 * 空间复杂度 O(n)
 * <p>
 * 稳定
 *
 * @author ：隋亮亮
 * @since ：2020/8/5 21:25
 */
public class MergeSortTestII {
    public static void main(String[] args) {
        int[] a = new int[]{7, 5, 6, 4};

//        sort1(a);
        mergeSort(a, 0, a.length - 1);

        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            if (arr[mid] < arr[mid + 1]) {
                return;
            }

            sort(arr, left, mid, right);
        }
    }

    public static void sort(int[] arr, int left, int mid, int end) {
        int tmpArr[] = new int[end - left + 1];

        int tmpLeft = left;
        int tmpRight = mid + 1;


        int k = 0;

        while (tmpLeft <= mid && tmpRight <= end) {
            tmpArr[k++] = arr[tmpLeft] <= arr[tmpRight] ? arr[tmpLeft++] : arr[tmpRight++];
        }

        while (tmpLeft <= mid) {
            tmpArr[k++] = arr[tmpLeft++];
        }

        while (tmpRight <= end) {
            tmpArr[k++] = arr[tmpRight++];
        }

        for (int i = 0; i < tmpArr.length; i++) {
            arr[left + i] = tmpArr[i];
        }
    }
}
