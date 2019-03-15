package zhanj.javaproxypattern.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import static zhanj.javaproxypattern.App.log;

import java.lang.reflect.Method;

public class HelloServiceProxy implements MethodInterceptor {

    @SuppressWarnings({"unchecked"})
    public static <T> T newInstance(T target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new HelloServiceProxy());
        return (T) enhancer.create();
    }

    /**
     * @param o     这个是实际生成的代理类，它继承了HelloService类。类名样例：zhanj.javaproxypattern.cglib.HelloService$$EnhancerByCGLIB$$32e1b70d
     * @param method    被代理方法
     * @param objects   调用被代理方法时传入的参数
     * @param methodProxy   代理方法
     * @return          调用被代理方法后的返回值
     * @throws Throwable 异常
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log("[CGLIB PROXY] try to invoke method ''{0}.{1}()''", o.getClass().getSimpleName(), method.getName());
        // 假如被代理对象是target，那么这里执行 method.invoke(target, objects) 也可以调用被代理的方法
        Object r = methodProxy.invokeSuper(o, objects);
        log("[CGLIB PROXY] method ''{0}.{1}()'' is invoked", o.getClass().getSimpleName(), method.getName());
        return r;
    }
}
