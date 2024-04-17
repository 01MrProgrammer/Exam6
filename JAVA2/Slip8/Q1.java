public class Q1 extends Thread {
    private String text;
    private int times;

    public Q1(String text, int times) {
        this.text = text;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.println(text);
        }
    }

    public static void main(String[] args) {
        Q1 thread1 = new Q1("COVID19", 10);
        Q1 thread2 = new Q1("LOCKDOWN2020", 20);
        Q1 thread3 = new Q1("VACCINATED2021", 30);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
