package zhanj.javaproxypattern.dynamic;

import static zhanj.javaproxypattern.App.log;

public class HelloService2Impl implements HelloService2 {

    @Override
    public void hello(String name) {
        log("hello {0} ! Are you OK ?", name);
    }
}
