/**
 * Author : xuan.
 * Date : 2019-05-29.
 * Description :二分查找
 * <p>
 * https://blog.csdn.net/lovesummerforever/article/details/24588989
 */
class QA20 {
    //非递归
    public static int binSearch(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while (start <= end) {
            mid = (end - start) / 2 + start;
            if (key < arr[mid]) {
                //左侧
                end = mid - 1;
            } else if (key > arr[mid]) {
                //右侧
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 递归
     */
    public static int binSearch(int[] arr, int start, int end, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int mid = (end - start) / 2 + start;
        if (arr[mid] == key) {
            return mid;
        }
        if (start >= end) {
            return -1;
        } else if (key < arr[mid]) {
            //左侧
            binSearch(arr, start, mid - 1, key);
        } else if (key > arr[mid]) {
            //右侧
            binSearch(arr, mid + 1, end, key);
        }
        return -1;
    }

    public static int binSearch2(int[] arr, int start, int end, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int mid = (end - start) / 2 + start;
        if (arr[mid] == key) {
            return mid;
        }
        if (start >= end) {
            return -1;
        } else if (key > arr[mid]) {
            binSearch2(arr, mid + 1, end, key);
        } else {
            binSearch2(arr, start, mid - 1, key);
        }
        return -1;
    }

    public static int binSearch2(int arr[], int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
