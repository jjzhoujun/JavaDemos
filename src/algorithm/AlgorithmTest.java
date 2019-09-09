package algorithm;

/**
 * @author JaydenZhou
 * @description 算法测试类
 * @date 19-9-9
 */
public class AlgorithmTest {

    public static void main(String[] args) {
        testQuickSort();
    }

    private static void testQuickSort() {
        int[] testArr = {5, 7, 4, 3, 6, 9, 1, 2, 10, 8};
        SortUtils.quickSort(testArr, 0, testArr.length - 1);
        for(int i=0; i< testArr.length; i++) {
            System.out.println(testArr[i]);
        }
    }
}
