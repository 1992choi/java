package basic.collectionframework;

import java.util.Iterator;

public class IteratorEx2 {

    public static void main(String[] args) {
        // Iterable과 Iterator를 사용하면 향상된 for문을 사용할 수 있다는 장점이 있다.
        MyArrayImplIter myArrayImplIter = new MyArrayImplIter(new int[]{1, 2, 3, 4});
        for (int element : myArrayImplIter) {
            System.out.print(element + " "); // 1 2 3 4
        }

        // 불가능 (Enhanced For 사용을 위해서는 제약조건이 있다. : array or java.lang.Iterable)
//        MyArray myArray = new MyArray(new int[]{1, 2, 3, 4});
//        for (int element : myArray) {
//            System.out.print(element + " ");
//        }
    }

    static class MyArray {

        private int[] numbers;

        public MyArray(int[] numbers) {
            this.numbers = numbers;
        }

    }

    static class MyArrayImplIter implements Iterable<Integer> {

        private int[] numbers;

        public MyArrayImplIter(int[] numbers) {
            this.numbers = numbers;
        }

        @Override
        public Iterator<Integer> iterator() {
            return new MyIterator(numbers);
        }

    }

    static class MyIterator implements Iterator<Integer> {

        private int currentIndex = -1;
        private int[] targetArr;

        public MyIterator(int[] targetArr) {
            this.targetArr = targetArr;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < targetArr.length - 1;
        }

        @Override
        public Integer next() {
            return targetArr[++currentIndex];
        }

    }

}
