package algorithm;

/**
 * 总体排序参考：https://www.cnblogs.com/guoyaohua/p/8600214.html
 * @author JaydenZhou
 * @description 排序算法工具类
 * @date 19-9-9
 */
public class SortUtils {

    /**
     * 快速排序，核心前后哨兵步步逼近，交换，每次跟基准的交换，分而治之递归排序。最后的递归退出条件
     * 默认第一个基准，时间复杂度 nlogN
     * 参考：https://blog.csdn.net/shujuelin/article/details/82423852
     * */
    public static void quickSort(int[] arr, int lowIndex, int highIndex) {
        if(lowIndex >= highIndex) {
            return ;
        }
        int i, j, tempValue, swapValue;
        tempValue = arr[lowIndex];
        i = lowIndex;
        j = highIndex;
        while(i < j) {
            while(arr[j] >= tempValue && i < j) {
                j--;
            }
            while(arr[i] <= tempValue && i < j) {
                i++;
            }
            if(i < j) {
                swapValue = arr[j];
                arr[j] = arr[i];
                arr[i] = swapValue;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[lowIndex] = arr[i];
        arr[i] = tempValue;
        quickSort(arr, lowIndex, j - 1);
        quickSort(arr, j + 1, highIndex);
    }

    private static void swapValue(int[] arr, int srcIndex, int desIndex) {
        int size = arr.length;
        if(srcIndex < 0 || srcIndex >= size || desIndex < 0 || desIndex >= size) {
            return ;
        }
        int temp;
        temp = arr[srcIndex];
        arr[srcIndex] = arr[desIndex];
        arr[desIndex] = temp;
    }

    /**
     * 选择排序，支持把升序、降序
     * 时间复杂度O（N2）
     * 不建议用这个，因为这里直接判断过后，不符合的话每次都交换
     * */
    @Deprecated
    public static void selectSort(int[] arr, boolean asce) {
        int size = arr.length;
        for(int i=0; i<size; i++) {
            for(int j=i+1; j<size; j++) {
                if(asce) {
                    if(arr[i] > arr[j]) {
                        swapValue(arr, i, j);
                    }
                } else {
                    if(arr[i] < arr[j]) {
                        swapValue(arr, i, j);
                    }
                }
            }
        }
    }

    /**
     * 要交换的时候，先记录index，循环结束后再交换
     * O(N2)
     */
    public static void selectSortV2(int[] arr, boolean asc) {
        int size = arr.length;
        if(size == 0) {
            return ;
        }
        int changeIndex = 0;
        boolean isChange = false;
        int tempValue;
        for(int i=0; i<size; i++) {
            changeIndex = i;
            for(int j=i+1; j<size; j++) {
                if(asc) {
                    if(arr[changeIndex] > arr[j]) {
                        isChange = true;
                        changeIndex = j;
                    }
                } else {
                    if(arr[changeIndex] < arr[j]) {
                        isChange = true;
                        changeIndex = j;
                    }
                }
            }
            if(isChange) {
                isChange = false;
                tempValue = arr[i];
                arr[i] = arr[changeIndex];
                arr[changeIndex] = tempValue;
            }
        }
    }

    /**
     * 冒泡排序，每次都从第一个开始，然后把符合条件（升序or降序）的挪到后面
     * */
    public static void bubbleSort(int[] arr, boolean asc) {
        int size = arr.length;
        if(size == 0) {
            return ;
        }
        for(int i=0; i<size; i++) {
            for(int j=0; j<size-i-1; j++) {
                if(asc) {
                    if(arr[j] > arr[j+1]) {
                        swapValue(arr, j, j+1);
                    }
                } else {
                    if(arr[j] < arr[j+1]) {
                        swapValue(arr, j, j+1);
                    }
                }
            }
        }
    }
}
