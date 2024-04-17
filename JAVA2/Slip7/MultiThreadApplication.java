import java.util.Random;

public class MultiThreadApplication {
    public static void main(String[] args) {
        NumberGeneratorThread generatorThread = new NumberGeneratorThread();
        SquareThread squareThread = new SquareThread();
        CubeThread cubeThread = new CubeThread();

        generatorThread.start();
        squareThread.start();
        cubeThread.start();
    }
}

class NumberGeneratorThread extends Thread {
    @Override
    public void run() {
        Random random = new Random();
        try {
            while (true) {
                int number = random.nextInt(100); // Generate a random number between 0 and 99
                System.out.println("Generated number: " + number);
                if (number % 2 == 0) {
                    synchronized (SquareThread.class) {
                        SquareThread.number = number;
                        SquareThread.class.notify();
                    }
                } else {
                    synchronized (CubeThread.class) {
                        CubeThread.number = number;
                        CubeThread.class.notify();
                    }
                }
                Thread.sleep(1000); // Wait for one second
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SquareThread extends Thread {
    static int number;

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (SquareThread.class) {
                    SquareThread.class.wait();
                    int square = number * number;
                    System.out.println("Square of " + number + ": " + square);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CubeThread extends Thread {
    static int number;

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (CubeThread.class) {
                    CubeThread.class.wait();
                    int cube = number * number * number;
                    System.out.println("Cube of " + number + ": " + cube);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
