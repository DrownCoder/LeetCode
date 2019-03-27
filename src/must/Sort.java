package must;

/**
 * Author : xuan.
 * Date : 2019-03-26.
 * Description :the description of this file
 */
class Sort {
    public static void main(String[] args) {
        int[] arr = {10, 9, 3, 2, 7, 9, 1, 8, 11};
        quickSort(arr, 0, arr.length - 1);
        printArr(arr);
    }

    private static void printArr(int[] arr) {
        for (int anArr : arr) {
            System.out.print(anArr + " ");
        }
    }

    //快排序
    public static void quickSort(int[] arr, int left, int right) {
        if (arr == null || left >= right || arr.length <= 1) {
            return;
        }
        int mid = sort(arr, left, right);
        quickSort(arr, left, mid - 1);
        quickSort(arr, mid + 1, right);
    }

    private static int sort(int[] arr, int left, int right) {
        int index = arr[left];
        while (right > left) {
            while (left < right && arr[right] >= index) {
                right--;
            }
            if (left < right) {
                arr[left] = arr[right];
                left++;
            }
            while (left < right && arr[left] <= index) {
                left++;
            }
            if (left < right) {
                arr[right] = arr[left];
                right--;
            }
        }
        arr[left] = index;
        return left;
    }
}
