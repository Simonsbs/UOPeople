class MyClass {

    static int count = 0;

    public MyClass() {

        count++;

    }

    public static int getCount() {

        return count;

    }

}

public class Main {

    public static void main(String[] args) {
        int x = 10;

        if (x > 5) {

            System.out.print("Hello");

            if (x < 15) {

                System.out.println("World");

            }

        }

    }

}