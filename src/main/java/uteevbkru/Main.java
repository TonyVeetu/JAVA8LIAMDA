package uteevbkru;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import static java.lang.ThreadLocal.withInitial;

public class Main {

    /**
     * Создать два потока через ThreadLocal  выводящих дату своего создания!
     * @param args
     */
    public static void main(String[] args) {
//      ThreadLocal<String> mapper = withInitial(() -> new String());
//      DateFormatter date = new DateFormatter();

        List<String> paramFromSfLabs = Stream.of("result", "request_id", "extra", "details")
                .collect(Collectors.toList());
        //todo дальше!!
        List<String> input = Stream.of("result", "request_id", "extra", "details", "a", "b", "cv", "")
                .collect(Collectors.toList());

//        int count = input.stream()
//                .filter( String -> {
//                    System.out.println( String);
//                    return  String.isEmpty();
//                })
//                .count();

        int sum = Stream.of(1, 2, 3)
                .reduce(0, (acc, element) -> acc + element);
    }

}
