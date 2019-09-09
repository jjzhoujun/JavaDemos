package learn;

import java.util.List;

/**
 * @author JaydenZhou
 * @description
 * @date 19-9-7
 */
public class CanvasCls {
    public void drawAll(List<Shape> shapes) {
        for(Shape shape : shapes) {
            shape.draw(this);
        }
    }
}
