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
        //insertSort(arr);
        //xierSort(arr);
        MergeSort(arr);
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

    public static void quickSort2(int[] arr, int left, int right) {
        if (arr == null || left > right || arr.length <= 1) {
            return;
        }
        int mid = sort2(arr, left, right);
        quickSort(arr, left, mid - 1);
        quickSort(arr, mid + 1, right);
    }

    private static int sort2(int[] arr, int left, int right) {
        //选最左边作为定点
        int index = arr[left];
        while (right > left) {
            //先找右边比定点小的
            while (arr[right] > index && left < right) {
                --right;
            }
            if (left < right) {
                arr[left] = arr[right];
                //右边停住，等左边比index大来赋值
                left++;
            }
            while (arr[left] < index && left < right) {
                ++left;
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
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSort2(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int temp;
        int length = arr.length;

        for (int i = 0; i < length - 1; i++) {
            boolean isSwap = false;
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwap = true;
                }
            }
            if (!isSwap) {
                return;
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

    public static void selectSort2(int[] a) {
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

    public static void insertSort2(int[] a) {
        if (a == null) {
            return;
        }
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 希尔排序
     * <p>
     * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，
     * 待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
     * https://www.cnblogs.com/chengxiao/p/6104371.html
     */
    public static void xierSort(int[] a) {
        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < a.length; i++) {
                int j = i;
                while (j - gap >= 0 && a[j] < a[j - gap]) {
                    swap(a, j, j - gap);
                    j -= gap;
                }
            }
        }
    }

    public static void xierSort2(int[] a) {
        if (a == null) {
            return;
        }
        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < a.length; i++) {
                int j = i;
                while (j - gap >= 0 && a[j - gap] < a[j]) {
                    swap(a, j - gap, j);
                    j -= gap;
                }
            }
        }
    }

    private static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }


    /**
     * 归并排序
     * 如果一个数组有n个数据，则可以把这个数组看作n个有序的子序列，每个子序列的长度为1，然后两两归并，
     * 就能得到[n/2]个长度为2（或者1，落单的)的字序列，再不断地两两归并，直到得到一个长度为n的有序数组。
     * https://www.jianshu.com/p/39dd1d9b491d
     * https://www.cnblogs.com/chengxiao/p/6194356.html
     */
    public static void MergeSort(int arr[]) {
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

    public static void mergeSort2(int[] a) {
        if (a == null) {
            return;
        }
        int[] temp = new int[a.length];

        mergeSortItem(a, 0, a.length, temp);
    }

    public static void mergeSortItem(int[] a, int left, int right, int[] temp) {
        int mid = (left + right) / 2;
        mergeSortItem(a, left, mid, temp);
        mergeSortItem(a, mid + 1, right, temp);
        merge2(a, left, mid, right, temp);
    }

    private static void merge2(int[] a, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid;
        int t = 0;
        while (i <= mid && j <= right) {
            if (a[i] < a[j]) {
                temp[t++] = a[i++];
            } else {
                temp[t++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = a[i++];
        }
        while (j <= right) {
            temp[t++] = a[j++];
        }
        t = 0;
        while (left <= right) {
            a[left++] = temp[t++];
        }
    }

}
