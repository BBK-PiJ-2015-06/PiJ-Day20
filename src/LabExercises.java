import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LabExercises {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hi", "hello", "hola","bonjour", "bye", "goodbye", "adios", "auvoir");

        //Question 1
        words.stream().forEach(w -> System.out.println("  " + w));

        //Question 2
        words.stream().forEach(System.out::println);

        //Question 3
        List<String> excitingWords = words.stream().map(w -> w + "!").collect(Collectors.toList());
        System.out.println(excitingWords);

        List<String> eyeWords = words.stream().map(w -> w.replace("i", "eye")).collect(Collectors.toList());
        System.out.println(eyeWords);

        List<String> upperCaseWords = words.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upperCaseWords);

        //Question 4
        List<String> shortWords = words.stream().filter(w -> w.length() < 4).collect(Collectors.toList());
        System.out.println(shortWords);

        List<String> wordsWithB = words.stream().filter(w -> w.contains("b")).collect(Collectors.toList());
        System.out.println(wordsWithB);

        List<String> evenLengthWords = words.stream().filter(w -> w.length() % 2 == 0).collect(Collectors.toList());
        System.out.println(evenLengthWords);

        //Question 5
        Optional<String> item = words.stream().filter(w -> w.length() < 4)
                .filter(w -> w.contains("e"))
                .map(String::toUpperCase).findFirst();
        System.out.println(item.get());

        //Question 7
        Optional<String> upperConcat = words.stream().reduce((v, w) -> v.toUpperCase() + w.toUpperCase());
        if(upperConcat.isPresent()) {
            System.out.println(upperConcat.get());
        }

        //Question 8
        Optional<String> upperConcat2 = words.stream().map(String::toUpperCase).reduce((v, w) -> v + w);
        if(upperConcat2.isPresent()) {
            System.out.println(upperConcat2.get());
        }

        //Question 9
        Optional<String> commas = words.stream().reduce((v, w) -> v + "," + w);
        if(commas.isPresent()) {
            System.out.println(commas.get());
        }

        //Question 10
            //See StreamUtils class
        System.out.println(StreamUtils.randomNumberList(10));

        //Question 11
            //See StreamUtils class
        System.out.println(StreamUtils.orderedNumberList(50, 5, 10));

        //Question 12
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        int sum = nums.stream().reduce(Integer::sum).get();
        System.out.println("Sum of " + nums + " is " + sum);

        //Question 13
        int sum2 = nums.stream().parallel().reduce(Integer::sum).get();
        System.out.println("Sum of " + nums + " is " + sum2);

        //Question 14
        List<Double> doubles = Arrays.asList(1.0, 2.0, 3.0, 4.0);
        double product = doubles.stream().reduce((x, y) -> x * y).get();
        System.out.println("Product of " + doubles + " is " + product);
        double product2 = doubles.stream().parallel().reduce((x, y) -> x * y).get();
        System.out.println("Product of " + doubles + " is " + product2);
    }
}
