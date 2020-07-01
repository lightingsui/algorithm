package search;

/**
 * 二分查找
 *
 * @author ：隋亮亮
 * @since ：2020/6/21 0:10
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int i = binarySearch(arr, 0);
        System.out.println("i = " + i);
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] > target) right = mid - 1;
            else if (arr[mid] < target) left = mid + 1;
            else return mid;
        }

        return -1;
    }
}
