import java.util.function.Predicate;

public class PredicateDemo{

    public static void main(String[] args) {

        int arr[] = {11,22,33,44,55,66,77,88,99};
        Predicate<Integer> p1 = (x)->x%2==0;

        Predicate<Integer> p2 =(x)->x>50;
        //checks if numbers are even
        processOnArray(arr, p1);

        //checks if numbers are odd
        processOnArray(arr, p1.negate());

        //checks if numbers are greater than 50
        processOnArray(arr, p2);

        //checks if numbers are 50 or less
        processOnArray(arr, p2.negate());

        //checks if numbers are even and greater than 50
        processOnArray(arr, p1.and(p2));

        //checks if numbers are odd and 50 or less
        processOnArray(arr, p1.negate().and(p2.negate()));

        //checks if numbers are odd or greater than 50
        processOnArray(arr, p1.negate().or(p2));
        
    }

    public static void processOnArray(int arr[],Predicate<Integer> p){
        for(int i=0;i<arr.length;i++){
            if(p.test(arr[i]))
                System.out.println(arr[i]);
        }
        System.out.println("----------------------");
    }
    
}