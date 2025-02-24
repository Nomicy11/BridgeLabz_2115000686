package Reflection;

import java.lang.reflect.*;

interface Greeting {
    void sayHello();
}

class Hello implements Greeting {
    public void sayHello() {
        System.out.println("Hello, World!");
    }
}

class LoggingProxy implements InvocationHandler {
    private final Object target;

    public LoggingProxy(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Logging: Calling method " + method.getName());
        return method.invoke(target, args);
    }
}

public class ProxyExample {
    public static void main(String[] args) {
        Greeting original = new Hello();
        Greeting proxy = (Greeting) Proxy.newProxyInstance(
                Hello.class.getClassLoader(),
                new Class[]{Greeting.class},
                new LoggingProxy(original));

        proxy.sayHello();
    }
}
