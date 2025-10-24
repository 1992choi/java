package javamistakes;

/*
    StringBuilder 생성자에 char 전달
    - StringBuilder의 생성자에는 string이 전달되기도 하지만 int가 전달되기도 한다.
      int는 초기 버퍼를 설정하는 인자값으로 활용되는데, 만약 개발자 실수로 char 형이 전달되면 묵시적으로 int로 변환되기 때문에 의도와 다른 문자열이 만들어질 수 있다.
 */
public class Ex082_StringBuilderCharConstructorBug {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder('['); // 개발자는 문자 [ 를 의도했으나, 컴파일러가 이해한 표현은 new StringBuilder(91); 과 같이 버퍼의 크기를 지정하는 int로 해석된다.
        sb.append("hello");
        sb.append(']');

        System.out.println(sb); // hello]
    }

}
