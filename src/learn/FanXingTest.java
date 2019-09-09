package learn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JaydenZhou
 * @description
 * @date 19-9-7
 */
public class FanXingTest {

    public static void main(String[] args) {
//        List<String> testList = new ArrayList<>();
//        test(testList);

        CanvasCls canvasCls = new CanvasCls();
        List<Shape> list = new ArrayList<>();
        list.add(new RectangleShape());
        list.add(new CircleShape());
        // 不能这样， 需要按照上面List<Shape>才行
//        List<CircleShape> list = new ArrayList<>();
        canvasCls.drawAll(list);
    }

    private static void test(List<Object> list) {
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
