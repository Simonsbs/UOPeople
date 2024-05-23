public class Main {
    public static void main(String[] args) {
        Clock clock = new Clock();
        Fibonachi fibonachi = new Fibonachi();

        Thread clockThread = new Thread(clock);
        clockThread.setPriority(Thread.MAX_PRIORITY);
        clockThread.start();

        Thread fibonacciTask = new Thread(fibonachi);
        fibonacciTask.setPriority(Thread.MIN_PRIORITY);
        fibonacciTask.start();
    }
}