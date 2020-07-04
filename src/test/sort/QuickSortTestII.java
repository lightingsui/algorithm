package test.sort;

/**
 * @author ：隋亮亮
 * @since ：2020/7/1 23:43
 */
public class QuickSortTestII {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 5, 9, 6, 4, 8, 7, 0};
        sort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void sort(int[] arr, int left, int right) {
        if(left < right) {
            int index = partition(arr, left, right);

            sort(arr, left, index - 1);
            sort(arr, index + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int i = left;

        while(i < right) {
            while(i < right && arr[right] >= arr[left]) right--;
            while(i < right && arr[i] <= arr[left]) i++;

            swap(arr, i, right);
        }

        swap(arr, i, left);

        return i;
    }

    public static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
