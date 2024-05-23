public class Fibonachi implements Runnable {
    @Override
    public void run() {
        // I chose to run from 40 to 100 to show the time taken for heavy computation
        // since my pc started to lag at 40, if your pc is faster you can increase the
        // range
        for (int i = 40; i <= 100; i++) {
            long fibNumber = fibonacci(i);
            System.out.println("Fibonacci(" + i + ") = " + fibNumber);
        }
    }

    // A simple recursive method to calculate the Fibonacci number
    private static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
