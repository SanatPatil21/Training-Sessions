import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

public class StreamDemo {
    public static void main(String args[]) {
        List<Integer> list = new ArrayList<Integer>();

        list.add(22);
        list.add(44);
        list.add(32);
        list.add(35);
        list.add(29);
        list.add(12);
        list.add(39);
        list.add(94);
        list.add(69);

        System.out.println(list);

        Predicate<Integer> p1 = (x) -> x % 2 == 0;
        /*
         * Stream s = list.stream();
         * Stream en = s.filter(p1);
         * 
         * List<Integer> elist = en.collect(Collectors.toList());
         * 
         * System.out.println(elist);
         */

        // Filter using the negation of the predicate
        List<Integer> olist = list.stream()
                .filter(p1.negate())
                .collect(Collectors.toList());
        System.out.println(olist);

        // Doubling the Values in list by performing "map" operation on the list
        List<Integer> dlist = list.stream().map(x -> x + x).collect(Collectors.toList());
        System.out.println(dlist);

        // Sorting and Skip and Limit
        List<Integer> slist = list.stream().sorted().limit(5).skip(2).collect(Collectors.toList());

        // Create a stream of random numbers
        Random random = new Random();
        random.ints().map(x -> Math.abs(x)).limit(10).forEach(System.out::println);

        System.out.println(slist);

        // Stream of Range of Integers
        IntStream is = IntStream.rangeClosed(1, 10);
        is.forEach(System.out::println);

        OptionalInt i = IntStream.range(1, 6).reduce((a, b) -> a + b);
        System.out.println(i.getAsInt());
        /*
         * Internal Working:-
         * 1
         * 2
         * 3
         * 4
         * 5
         * 
         * (a,b)->1+2=3
         * (3,3)->3+3=6
         * (6,4)->6+4=10
         * (10,5)->10+5=15
         */

        // A base value to start the "reduce" with :- identity
        int res1 = Stream.of(1, 2, 3).reduce(10, (a, b) -> a + b);
        System.out.println(res1);

        int res2 = Arrays.asList(1, 2, 3).parallelStream().reduce(10, (a, b) -> a + b, (a, b) -> a + b);
        System.out.println(res2);


        IntSummaryStatistics stats = IntStream.range(1, 10).summaryStatistics();

        System.out.println(stats);
        System.out.println("Count: "+stats.getCount());
        System.out.println("Min: "+stats.getMin());
        System.out.println("Max: "+stats.getMax());
        System.out.println("Sum: "+stats.getSum());
        System.out.println("Average: "+stats.getAverage());


    }
}