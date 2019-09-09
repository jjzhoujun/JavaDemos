package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 参考反射  https://blog.csdn.net/briblue/article/details/74616922
 **/
public class DriveTest {

    public static void main(String[] args) {
        System.out.println("DriveTest...Start....");
        AutoDrive car = new AutoDrive();
        car.drive();
        System.out.println("=======>>>>Prepare auto drive...");

        Class cls = AutoDrive.class;
        try {
            Constructor cons = cls.getConstructor(String.class, AutoDrive.Color.class);
            AutoDrive autoDrive = (AutoDrive) cons.newInstance("Tesla", AutoDrive.Color.RED);
            Method method = cls.getMethod("drive");
            System.out.println("====>>>>Start auto drive...");
            method.invoke(autoDrive, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
