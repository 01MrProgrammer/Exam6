public class Q1 {
    public static void main(String[] args) {
        Thread printerThread1 = new TextPrinterThread("A",10);
        Thread printerThread2 = new TextPrinterThread("B",20);
        Thread printerThread3 = new TextPrinterThread("A",30);

        printerThread1.start();
        printerThread2.start();
        printerThread3.start();
    }
}
class TextPrinterThread extends Thread{
        private String text;
        private int time;

        public TextPrinterThread(String text,int time){
            this.text = text;
            this.time = time;
        }
}
