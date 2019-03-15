package zhanj.javaproxypattern.cglib;

import static zhanj.javaproxypattern.App.log;

public class HelloService {

    public void hello(String name) {
        log("Hello {0} ! are you OK ?", name);
    }
}
