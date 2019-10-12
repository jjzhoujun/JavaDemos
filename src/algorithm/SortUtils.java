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
        int i, j, baseValue, swapValue;
        baseValue = arr[lowIndex];
        i = lowIndex;
        j = highIndex;
        while(i < j) {
            // 从j开始从右到左，为什么一定要从右到左呢？ ==》》可断点跑quickSortV2方法
            while(arr[j] >= baseValue && i < j) {
                j--;
            }
            while(arr[i] <= baseValue && i < j) {
                i++;
            }
            // 相等时候就不换
            if(i < j) {
                swapValue = arr[j];
                arr[j] = arr[i];
                arr[i] = swapValue;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[lowIndex] = arr[i];
        arr[i] = baseValue;
        for(int tempValue : arr) {
            System.out.print(tempValue + " ");
        }
        System.out.println();
        quickSort(arr, lowIndex, j - 1);
        quickSort(arr, j + 1, highIndex);
    }

    /**
     * 该函数有误的，因为i先跑的话，因为默认有i++，会导致最后交换的时候，可能会把不需要的数据交换了。
     * 快排，找到基准，然后从左到右先跑一遍；同上那个输出结果默认也是升序
     * */
    @Deprecated
    public static void quickSortV2(int[] arr, int lowIndex, int highIndex) {
        if(lowIndex >= highIndex) {
            return ;
        }
        int temp;
        int i = lowIndex;
        int j = highIndex;
        int baseValue = arr[lowIndex];
        while(i < j) {
            while(baseValue >= arr[i] && i < j) {
                i++;
            }
            while(baseValue <= arr[j] && i < j) {
                j--;
            }
            if(i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[lowIndex] = arr[i];
        arr[i] = baseValue;
        for(int tempValue : arr) {
            System.out.print(tempValue + " ");
        }
        System.out.println();
        quickSortV2(arr, 0, i - 1);
        quickSortV2(arr, i + 1, highIndex);
    }

    /**
     * 快排的降序版本, 也是j先行，然后退出循环后相换
     * */
    public static void quickSortDes(int[] arr, int lowIndex, int hightIndex) {
        if(lowIndex >= hightIndex) {
            return ;
        }
        int baseValue = arr[lowIndex];
        int i = lowIndex;
        int j = hightIndex;
        int temp;
        while(i < j) {
            while(baseValue >= arr[j] && i < j) {
                j--;
            }
            while(baseValue <= arr[i] && i < j) {
                i++;
            }
            if(i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[lowIndex] = arr[i];
        arr[i] = baseValue;
        quickSortDes(arr, 0, i - 1);
        quickSortDes(arr, i + 1, hightIndex);
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
     * 要交换的时候，先记录此刻最大（最小值）对应的index，拿此index值跟后续比较，外层循环结束后再交换
     * O(N2)
     */
    public static void selectSortV2(int[] arr, boolean asc) {
        int size = arr.length;
        if(size == 0) {
            return ;
        }
        int changeIndex = 0;
        int tempValue;
        for(int i=0; i<size; i++) {
            changeIndex = i;
            for(int j=i+1; j<size; j++) {
                if(asc) {
                    if(arr[changeIndex] > arr[j]) {
                        changeIndex = j;
                    }
                } else {
                    if(arr[changeIndex] < arr[j]) {
                        changeIndex = j;
                    }
                }
            }
            if(changeIndex != i) {
                tempValue = arr[i];
                arr[i] = arr[changeIndex];
                arr[changeIndex] = tempValue;
            }
        }
    }

    /**
     * 冒泡排序，每次都从第一个开始，比较相邻两个元素，把符合条件（升序or降序）的挪到后面，第二层循环size不断减少
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

    /**
     * 插入排序，前面的都是已经排序的，然后从i+1往前扫描，如果有遇到比它小的，就把前面的往后移位，直到遇到相等或者小于的。
     * 关键点是记录 current值以及往后替换排位
     * */
    public static void insertSort(int[] arr, boolean asc) {
        int size = arr.length;
        if(size == 0) {
            return ;
        }
        int current = 0;
        int prevIndex = 0;
        for(int i=0; i<size-1; i++) {
            current = arr[i+1];
            prevIndex = i;
            if(asc) {
                while (prevIndex >= 0 && current < arr[prevIndex]) {
                    arr[prevIndex + 1] = arr[prevIndex];
                    prevIndex--;
                }
            } else {
                while(prevIndex >= 0 && current > arr[prevIndex]) {
                    arr[prevIndex + 1] = arr[prevIndex];
                    prevIndex--;
                }
            }
            arr[prevIndex+1] = current;
        }
    }
}
