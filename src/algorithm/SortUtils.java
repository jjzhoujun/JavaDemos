package algorithm;

/**
 * @author JaydenZhou
 * @description 排序算法工具类
 * @date 19-9-9
 */
public class SortUtils {

    /**
     * 快速排序，核心前后哨兵步步逼近，交换，每次跟基准的交换。最后的递归退出条件
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
}
