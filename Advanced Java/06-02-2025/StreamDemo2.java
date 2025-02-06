import java.util.*;
import java.util.stream.*;

public class StreamDemo2 {

	public static void main(String args[]) {
		Map<Integer, String> map = new HashMap<Integer, String>();

		map.put(11, "Sanat");
		map.put(22, "Sumit");
		map.put(33, "Maddy");
		map.put(44, "Pushpa");
		map.put(55, "Kadu");

		map.entrySet().stream().map(Map.Entry::getKey).forEach(System.out::println);
		map.entrySet().stream().map(Map.Entry::getValue).forEach(System.out::println);
		System.out.println("----------------");
		map.entrySet().stream().filter(me -> me.getKey() > 30).forEach(System.out::println);
		System.out.println("-----------------");

		List<Integer> l1 = Arrays.asList(1, 2, 3);
		// List<Integer> l2 = Arrays.asList(4,5,6,7);
		// We can also add a Set along with the List and use FlatMap on it, since all
		// are finally Collection Objects
		Set<Integer> l2 = new TreeSet<Integer>();
		l2.add(4);
		l2.add(5);
		l2.add(6);
		l2.add(7);

		List<Integer> l3 = Arrays.asList(8, 9, 10);

		// List<List<Integer>> list = Arrays.asList(l1,l2,l3);
		// We just need add <Collection<Integer>> as the generic type instead of
		// List<Integer>
		List<Collection<Integer>> list = Arrays.asList(l1, l2, l3);
		System.out.println(list);

		//FlatMap can flatten the List of Lists or List of Collections etc
		List<Integer> flatList = list.stream()
				.flatMap(coll -> coll.stream())
				.map(x -> x + x)
				.collect(Collectors.toList());
		System.out.println(flatList);

	}

}