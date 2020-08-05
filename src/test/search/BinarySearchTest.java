package test.search;

/**
 * @author ：隋亮亮
 * @since ：2020/8/5 23:54
 */
public class BinarySearchTest {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int i = binarySearch(arr, 4);
        System.out.println("i = " + i);
    }

    private static int binarySearch(int[] arr, int i) {
        int left = 0;
        int right = arr.length - 1;

        while(left < right) {
            int mid = left + (right - left) / 2;

            if(i > arr[mid]) {
                left = mid + 1;
            } else if(i < arr[mid]) {
                right = mid;
            } else {
                return mid;
            }
        }

        return 0;
    }
}
