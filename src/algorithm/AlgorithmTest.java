package algorithm;

/**
 * @author JaydenZhou
 * @description 算法测试类
 * @date 19-9-9
 */
public class AlgorithmTest {

    public static void main(String[] args) {
        testSort();
    }

    private static void testSort() {
        int[] testArr = {1, 5, 7, 4, 3, 6, 9, 2, 10, 8};
        System.out.println("Origin Array is : ");
        for(int i=0; i< testArr.length; i++) {
            System.out.print(testArr[i] + " ");
        }
        System.out.println();
//        SortUtils.quickSort(testArr, 0, testArr.length - 1);
//        SortUtils.quickSortDes(testArr, 0, testArr.length - 1);
//        SortUtils.quickSortV2(testArr, 0, testArr.length - 1);
//        SortUtils.selectSort(testArr, true);
//        SortUtils.selectSortV2(testArr, true);
//        SortUtils.bubbleSort(testArr, true);
        SortUtils.insertSort(testArr, true);
        System.out.println("After sorted : ");
        for(int i=0; i< testArr.length; i++) {
            System.out.print(testArr[i] + " ");
        }
    }
}
