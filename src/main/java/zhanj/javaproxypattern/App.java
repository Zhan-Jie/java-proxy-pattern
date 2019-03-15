package zhanj.javaproxypattern;

import zhanj.javaproxypattern.cglib.HelloService;
import zhanj.javaproxypattern.cglib.HelloServiceProxy;
import zhanj.javaproxypattern.dynamic.HelloService2;
import zhanj.javaproxypattern.dynamic.HelloService2Impl;
import zhanj.javaproxypattern.dynamic.HelloService2Proxy;

import java.text.MessageFormat;

public class App {

    public static void main(String[] args) {
        HelloService service1 = new HelloService();
        HelloService proxy = HelloServiceProxy.newInstance(service1);
        proxy.hello("world");

        HelloService2 service2 = new HelloService2Impl();
        HelloService2 proxy2 = HelloService2Proxy.newInstance(service2);
        proxy2.hello("haha");
    }

    public static void log(String pattern, Object... args) {
        String message = args.length > 0 ? MessageFormat.format(pattern, args) : pattern;
        System.out.println(message);
    }
}
