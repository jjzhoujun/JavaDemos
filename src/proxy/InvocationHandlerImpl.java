package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author JaydenZhou
 * @description 调用处理器实现类
 * 每次生成动态代理类对象时都需要指定一个实现了该接口的调用处理器对象
 * @date 19-7-19
 */
public class InvocationHandlerImpl implements InvocationHandler {

    // 要代理的对象
    private Object subject;

    public InvocationHandlerImpl(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Before
        System.out.println("调用之前的操作。。。。");
        System.out.println("Method: " + method);
        //当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
        Object reValue = method.invoke(subject, args);
        // After
        System.out.println("调用之后的操作。。。。");
        return reValue;
    }
}
