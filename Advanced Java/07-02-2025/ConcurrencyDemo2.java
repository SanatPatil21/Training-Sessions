import java.util.concurrent.*;

public class ConcurrencyDemo2 {
    public static void main(String[] args) throws Exception {
        // Creating a Thread Pool
        ExecutorService es = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        //getRuntime().availableProcessors() gets us how many threads can be created for the current machine

        es.submit(new Greet());
        Future<Integer> f1 = es.submit(new Sum(5));
        //.submit() returns future because the task submitted to it may or may not give any result
        Future<Integer> f2 = es.submit(new Sum(10));

        Future<Integer> f3 = es.submit(new Sum(20));

        System.out.println("Sum of 5: " + f1.get());
        System.out.println("Sum of 10: " + f2.get());
        System.out.println("Sum of 20: " + f3.get());

        es.shutdown();
    }
}

class Greet implements Runnable {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("From Greet: " + i);
        }
    }
}

//We want this class to be a "returnable" thread, so it should implements Callable with a Generic Type of whatever we want tor return
class Sum implements Callable<Integer> {
    int val;

    Sum(int val) {
        this.val = val;
    }

    //Unlike Runnable, we override call() method here
    public Integer call() {

        int res = 0;
        for (int i = 0; i <= val; i++) {
            res = res + i;
        }

        return res;

    }
}