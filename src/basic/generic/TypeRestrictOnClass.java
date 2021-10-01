package basic.generic;

class Lang {}
class C extends Lang {}
class Java extends Lang {}

class Tool {}
class Eclipse extends Tool {}
class IntelliJ extends Tool {}

class DevTool<T extends Tool> {} // 제네릭 타입으로 Tool 또는 그 자식 클래스만 대입 가능

public class TypeRestrictOnClass {

    public static void main(String[] args) {
        DevTool<Tool> devTool1 = new DevTool<>();
        DevTool<Eclipse> devTool2 = new DevTool<>();
        DevTool<IntelliJ> devTool3 = new DevTool<>();
        /* 불가
            DevTool<Lang> devTool4 = new DevTool<>();
            DevTool<C> devTool5 = new DevTool<>();
            DevTool<Java> devTool6 = new DevTool<>();
         */
    }

}
