import java.util.*;
import java.util.stream.*;

public class StreamDemo3 {
    public static void main(String[] args) {

        List<Emp> list = new ArrayList<Emp>();

        list.add(new Emp("Sujata", 31, 70000, "Manager"));
        list.add(new Emp("Ravi", 33, 90000, "Programmer"));
        list.add(new Emp("Pushpa", 28, 40000, "Manager"));
        list.add(new Emp("Rohit", 32, 80000, "Programmer"));
        list.add(new Emp("Sanat", 25, 10000, "Tester"));
        list.add(new Emp("Sumit", 26, 20000, "Programmer"));
        list.add(new Emp("Maddy", 27, 30000, "Manager"));
        list.add(new Emp("Kadu", 29, 50000, "Tester"));
        list.add(new Emp("Suman", 30, 60000, "Programmer"));
        list.add(new Emp("Rajesh", 34, 100000, "Tester"));

        // Preferable when u need records that satify condition plus do not satisfy
        // condition
        // WHEN TO USE WHAT
        /*
         * filter() -> when only one condition
         * groupingBy() -> when more than two conditions or there might be more than two
         * in the future
         * partioningBy() -> when there are two conditions
         */
        // Partitioning the employees based on age greater than 30
        Map<Boolean, List<Emp>> m1 = list.stream()
                .collect(Collectors.partitioningBy(e -> e.getAge() > 30));
        System.out.println(m1);

        System.out.println("----------------");

        // Counting employees based on whether their age is greater than 30
        Map<Boolean, Long> m2 = list.stream()
                .collect(Collectors.partitioningBy(e -> e.getAge() > 30, Collectors.counting()));
        System.out.println(m2);

        System.out.println("----------------");

        // Grouping employees by their designation
        Map<String, List<Emp>> m3 = list.stream()
                .collect(Collectors.groupingBy(e -> e.getDesig()));
        System.out.println(m3);

        System.out.println("----------------");

        // Counting employees in each designation group
        Map<String, Long> m4 = list.stream()
                .collect(Collectors.groupingBy(e -> e.getDesig(), Collectors.counting()));
        System.out.println(m4);

        System.out.println("----------------");

        // Grouping employees by designation and mapping to their names
        Map<String, List<String>> m5 = list.stream()
                .collect(Collectors.groupingBy(e -> e.getDesig(),
                        Collectors.mapping(e -> e.getName(), Collectors.toList())));
        System.out.println(m5);


        // Raise Salary acc to designation
        list.stream()
                .collect(Collectors.groupingBy(Emp::getDesig))
                .forEach((designation, employees) -> {
                    int raiseAmount = switch(designation)  {
                        case "Manager" -> 10000;
                        case "Programmer" -> 5000;
                        case "Tester" -> 2000;
                        default -> 0;
                    };
                    employees.forEach(e -> e.raiseSalary(raiseAmount));
                });
        System.out.println("---------------");
        System.out.println("RAISED SALARY");
        list.forEach(System.out::println);

        // Map<String,List<Emp>> m6 =
        // list.stream().collect(Collectors.groupingBy(e->e.getDesig()));

    }

}

class Emp {
    private String name;
    private int age;
    private int salary;
    private String desig;

    public Emp(String n, int a, int s, String d) {
        name = n;
        age = a;
        salary = s;
        desig = d;

    }

    public int getAge() {
        return age;
    }

    public String getDesig() {
        return desig;
    }

    public String getName() {
        return name;
    }

    public void raiseSalary(int salaryInc) {
        this.salary += salaryInc;
    }

    public String toString() {
        return "Emp{name='" + name + "', age=" + age + ", salary=" + salary + ", desig='" + desig + "'}";
    }

}