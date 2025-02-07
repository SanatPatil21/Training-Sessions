import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.*;

public class ConcurrencyDemo3 {
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Using supplyAsync for String type : " + i);

            }
            return "Comeplted the String argument execution";
        }).orTimeout(5,TimeUnit.SECONDS).exceptionally(s->"You have delayed to give result");
        CompletableFuture.runAsync(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Using runAsync : " + i);

            }
        });

        CompletableFuture<Double> cf2 = CompletableFuture.supplyAsync(() -> {
            double res = 0;
            for (int i = 1; i <= 10; i++) {
                System.out.println("Using supplyAsync for Double type : " + i);

            }

            for (int j = 1; j <= 100; j++) {
                res = res + j;

            }
            return res;
        });

        // System.out.println("Result: "+cf1.get());

        // CompletableFuture<Void> f = CompletableFuture.allOf(cf1,cf2);
        // f.join();

        cf2.thenApplyAsync((x)->{
            System.out.println("Summing till 100 is : "+x);
            return x;
        });

        System.out.println("Main exit");
        Thread.sleep(100);

    }

}
