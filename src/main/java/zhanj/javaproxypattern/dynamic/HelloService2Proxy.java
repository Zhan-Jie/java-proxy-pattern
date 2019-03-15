package zhanj.javaproxypattern.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static zhanj.javaproxypattern.App.log;

public class HelloService2Proxy implements InvocationHandler {

    private Object target;

    @SuppressWarnings({"unchecked"})
    public static <T> T newInstance(T target) {
        HelloService2Proxy proxy = new HelloService2Proxy();
        proxy.target = target;
        Class<?> targetClass = target.getClass();
        return (T) Proxy.newProxyInstance(targetClass.getClassLoader(), targetClass.getInterfaces(), proxy);
    }

    /**
     *
     * @param proxy 生成的代理对象，它实现了HelloService2接口。类名样例：com.sun.proxy.$Proxy0
     * @param method    被代理的方法
     * @param args      调用被代理方法时传入的参数
     * @return          调用被代理方法后返回的结果
     * @throws Throwable  异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log("[JDK DYNAMIC PROXY] try to invoke method ''{0}''", method.getName());
        Object r = method.invoke(target, args);
        log("[JDK DYNAMIC PROXY] method ''{0}'' is invoked", method.getName());
        return r;
    }
}
