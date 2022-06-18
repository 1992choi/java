package basic.clazz;

public class IsInstance {

    public static void main(String[] args) throws ClassNotFoundException {
        ParentClazz parentClazz = new ParentClazz();
        System.out.println(Class.forName("basic.clazz.Clazz").isInstance(parentClazz)); // false
        System.out.println(Class.forName("basic.clazz.ParentClazz").isInstance(parentClazz)); // true

        ParentClazz parentClazz2 = new Clazz();
        System.out.println(Class.forName("basic.clazz.Clazz").isInstance(parentClazz2)); // true
        System.out.println(Class.forName("basic.clazz.ParentClazz").isInstance(parentClazz2)); // true

        Clazz clazz = new Clazz();
        System.out.println(Class.forName("basic.clazz.Clazz").isInstance(clazz)); // true
        System.out.println(Class.forName("basic.clazz.ParentClazz").isInstance(clazz)); // true
    }
}

class ParentClazz {
}
class Clazz extends ParentClazz {
}