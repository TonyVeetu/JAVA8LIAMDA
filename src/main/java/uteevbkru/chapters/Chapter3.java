package uteevbkru.chapters;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Chapter3 {


    public static int AddUp(Stream<Integer> numbers) {
        return numbers.reduce(0, (acc, x) -> acc + x);
    }

    public static void main(String[] args) {
        /** 1.a check function AddUp */
        List<Integer> ints = Stream.of(1,2,3,4,5)
                .collect(toList());
        int sym = AddUp(ints.stream());
        System.out.println(sym);

        /** 1.b In class Album */

        /** 1.c In class Album */

        /** 2 Итерирование */




    }
}
