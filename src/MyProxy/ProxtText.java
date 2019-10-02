package MyProxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxtText {
    public static void main(String[] args) {
        HotDog hotDog = new HotDog();
      Dog wang=(Dog)Proxy.newProxyInstance(hotDog.getClass().getClassLoader(), hotDog.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("执行");
                System.out.println(method.getName());
                System.out.println(Arrays.toString(args));
                if("eat".equals(method.getName())){
                    System.out.println("运行了");
                }
                Object aa = method.invoke(hotDog, args);
                return aa;
            }
        });
                wang.eat("啊啊");
    }
}
