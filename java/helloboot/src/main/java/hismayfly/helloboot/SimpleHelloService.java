package hismayfly.helloboot;

public class SimpleHelloService implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name + " " + "from HelloService with DI";
    }
}
