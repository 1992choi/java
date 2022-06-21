package basic.collectionframework;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackEx {

    public static void main(String[] args) {
        // LIFO(Last In First Out) : 마지막에 저장된 것을 제일 먼저 꺼낸다.
        Stack<String> stack = new Stack<>();
        // 데이터 추가
        stack.push("가");
        stack.push("나");
        stack.push("다");
        stack.push("라");
        stack.push("마");
        System.out.println(stack); // [가, 나, 다, 라, 마]

        // TOP 확인
        System.out.println(stack.peek()); // 마
        System.out.println(stack); // [가, 나, 다, 라, 마]

        // 데이터 추출
        System.out.println(stack.pop()); // 마
        System.out.println(stack.pop()); // 라
        System.out.println(stack); // [가, 나, 다]
        
        // 데이터 검색
        System.out.println(stack.search("다")); // 1 : TOP부터 1로 순서가 할당된다.
        System.out.println(stack.search("가")); // 3
        System.out.println(stack.search("하")); // -1 : 없으면 -1 리턴

        // 스택활용 - 괄호 일치 여부(올바른 수식)
        stack = new Stack<>();
        String result = "";
        String expression = "((3+5)*8-2)*3";
        try {
            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);

                if (ch == '(') {
                    stack.push(String.valueOf(ch));
                } else if (ch == ')') {
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                result = "올바른 수식";
            } else {
                result = "오류 수식";
            }
        } catch (EmptyStackException e) {
            result = "오류 수식";
        }
        System.out.println(result); // 올바른 수식

        // 스택활용 - 괄호 일치 여부(오류 수식)
        expression = "(3+5)*8-2)*3";
        try {
            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);

                if (ch == '(') {
                    stack.push(String.valueOf(ch));
                } else if (ch == ')') {
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                result = "올바른 수식";
            } else {
                result = "오류 수식";
            }
        } catch (EmptyStackException e) {
            result = "오류 수식";
        }
        System.out.println(result); // 오류 수식
    }

}
