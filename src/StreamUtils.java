import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUtils {

    public static List<Double> randomNumberList(int listSize) {
        return new Random().doubles(listSize).boxed().collect(Collectors.toList());
    }

    public static List<Integer> orderedNumberList(int start, int step, int size) {
        return Stream.iterate(start, n -> n + step).limit(size).collect(Collectors.toList());
    }
}
