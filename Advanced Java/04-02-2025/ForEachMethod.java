import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class A implements Consumer<String>{
    public void accept(String str){
        System.out.println("Good name is "+str);

    }
}


class B{

    public static void writeToFile(String str){
        System.out.println("writtten to csv file:  "+str);

    }
    
}


public class ForEachMethod{
    public static void main(String[] args) {

        List<String> employees = Arrays.asList("Suman","Sujata","Supriya","Sunita");

        employees.forEach(B::writeToFile);

        employees.forEach(new A());

        employees.forEach((arg)->{
            System.out.println("This is new Employee: "+arg);
        });

        employees.forEach(System.out::println);
        
    }
}