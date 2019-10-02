package MyProxy;

public class HotDog implements Dog {
    @Override
    public void eat() {
        System.out.println("吃");
    }
    public void eat(String c){
        System.out.println("吃"+c);
    };

    @Override
    public String sleep() {
        System.out.println("睡");
        return null;
    }
}
