package uteevbkru.chapters;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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

        /** 1.b -> In class Album */

        /** 1.c -> In class Album */

        /** 2 Итерирование -> in main of Reader */

        /** 6 Подсчитать количество строчных букв */
        String a = new String("sasdf DDDDD");
        System.out.println(countNotLowercaseLetters(a));

        /** 7 Найти самую длинную строку со строчными символами */
        List<String> list = Stream.of("Max","pushing","bread","Water","fid")
                .collect(toList());

        System.out.println(findStringWithMaxNotLowercaseLetters(new ArrayList<>()));
    }

    public static int countNotLowercaseLetters(String str){
        return (int) str.chars()
                .filter(Character::isLowerCase)
                .count();
    }

    public static Optional<String> findStringWithMaxNotLowercaseLetters(List<String> list){
        return list.stream()
                   .max(Comparator.comparing(Chapter3::countNotLowercaseLetters));
    }


}
