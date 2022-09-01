package basic.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayToList {

    public static void main(String[] args) {

        // 1. 문자 배열 -> 리스트
        String[] str = {"aaa", "b", "ccc", "d", "eee"};
        List<String> strList = Arrays.asList(str);
        System.out.println(strList); // [aaa, b, ccc, d, eee]

        // 2. Integer 배열 -> 리스트
        Integer[] integers = {1, 2, 3, 4, 5};
        List<Integer> integerList = Arrays.asList(integers);
        System.out.println(integerList); // [1, 2, 3, 4, 5]

        // 3. int 배열 -> 리스트
        int[] ints = {1, 1, 1, 2, 3};
        List<Integer> intList = Arrays.stream(ints).boxed().collect(Collectors.toList());
        System.out.println(intList); // [1, 1, 1, 2, 3]

        // 4. char 배열 -> 리스트
        Character[] characters = {'a', 'b', 'c'};
        List<Character> characterList = Arrays.asList(characters);
        System.out.println(characterList); // [a, b, c]

        // 5. char 배열 -> 리스트
        char[] chars = {'x', 'y', 'z'};
        List<Character> charList = IntStream.range(0, chars.length).mapToObj(i -> chars[i]).collect(Collectors.toList());
        System.out.println(charList); // [x, y, z]

    }

}
