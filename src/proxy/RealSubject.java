package proxy;

/**
 * @author JaydenZhou
 * @description 实际对象
 * @date 19-7-19
 */
public class RealSubject implements Subject{

    @Override
    public String sayHello(String name) {
        return "Hello" + name;
    }

    @Override
    public String sayGoodBye() {
        return "Good Bye";
    }
}
