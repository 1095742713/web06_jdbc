package MyProxy;


import java.lang.reflect.Proxy;

public class ProxText2 {
    public static void main(String[] args) {
        HotDog hotDog = new HotDog();
        Dog wang=(Dog)Proxy.newProxyInstance(hotDog.getClass().getClassLoader(),hotDog.getClass().getInterfaces(),(Proxy,Method,Args)->{
            if("eat".equals(Method.getName())){
                System.out.println("11111");
            }
            return Method.invoke(hotDog,args);
        });
        wang.eat("c");
    }
}
