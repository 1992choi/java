package basic.generic;

class Apple {}

class Watch {}

class Goods {
    private Object obj = new Object();

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}

class GoodsUsingGeneric<T> {
    private T t;

    public T get() {
        return t;
    }

    public void set(T t) {
        this.t = t;
    }
}

public class DifferenceObjectAndGeneric {

    public static void main(String[] args) {
        /* 다양한 타입을 제어하기 위하여 Object 사용 */
        Goods goods1 = new Goods();
        goods1.setObj(new Apple());
        Apple apple1 = (Apple)goods1.getObj(); // 다운캐스팅 필요

        Goods goods2 = new Goods();
        goods2.setObj(new Watch());
        Watch watch1 = (Watch)goods2.getObj(); // 다운캐스팅 필요

        Goods goods3 = new Goods();
        goods3.setObj(new Apple());
        /* java.lang.ClassCastException.
           문법상으로는 오류가 없지만 실행 예외 발생(사용자의 실수에 의하여 발생 가능)
         */
        Watch watch2 = (Watch)goods3.getObj();


        /* 다양한 타입을 제어하기 위하여 Generic 사용 */
        GoodsUsingGeneric<Apple> goodsUsingGeneric1 = new GoodsUsingGeneric<>();
        goodsUsingGeneric1.set(new Apple());
        Apple appleUsingGeneric1 = goodsUsingGeneric1.get(); // 다운캐스팅 필요 없음

        GoodsUsingGeneric<Watch> goodsUsingGeneric2 = new GoodsUsingGeneric<>();
        goodsUsingGeneric2.set(new Watch());
        Watch watchUsingGeneric1 = goodsUsingGeneric2.get(); // 다운캐스팅 필요 없음

        GoodsUsingGeneric<Apple> goodsUsingGeneric3 = new GoodsUsingGeneric<>();
        goodsUsingGeneric3.set(new Apple());
        // Watch watchUsingGeneric2 = goodsUsingGeneric3.get(); // 문법 오류로 표시되어 사전에 오류 방지
    }

}
