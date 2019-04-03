package must;

/**
 * Author : xuan.
 * Date : 2019-03-26.
 * Description :the description of this file
 */
class Sort {
    public static void main(String[] args) {
        int[] arr = {10, 9, 3, 2, 7, 9, 1, 8, 11};
        //quickSort(arr, 0, arr.length - 1);
        //bubbleSort(arr);
        //selectSort(arr);
        insertSort(arr);
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

    //冒泡排序

    /**
     * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * <p>
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * <p>
     * 针对所有的元素重复以上的步骤，除了最后一个；
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int length = arr.length;
        int temp;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //选择排序

    /**
     * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
     * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 以此类推，直到所有元素均排序完毕。
     */
    public static void selectSort(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        int min;
        int minIndex = 0;
        for (int i = 0; i < a.length; i++) {
            min = a[i];
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    minIndex = j;
                }
            }
            if (min < a[i]) {
                a[minIndex] = a[i];
                a[i] = min;
            }
        }
    }

    //插入排序

    /**
     * 从第一个元素开始，该元素可以认为已经被排序；
     * <p>
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * <p>
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * <p>
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * <p>
     * 将新元素插入到该位置后；
     * <p>
     * 重复步骤2~5。
     */
    public static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    //和前面的比，如果小于，则交换
                    int temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
