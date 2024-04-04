public class Q1 extends Thread{
    char ch;
    public void run()
    {
        for(ch='A';ch<='Z';ch++)
       // for(ch='a';ch<='z';ch++)
        {
            System.out.println(""+ch);
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Q1 t=new Q1();
        t.start();
    }
}

/*public class Q1 {

    public static void main(String[] args) throws InterruptedException {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print(ch + " ");
            Thread.sleep(2000); // Sleep for 2 seconds
        }
        System.out.println(); // Print a newline after all characters
    }
}*/


/*
public class AlphabetDisplay {
    public static void main(String[] args) {
        char letter;
        for (letter = 'A'; letter <= 'Z'; ++letter) {
            System.out.print(letter + " ");
            try {
                Thread.sleep(2000); // Pause for 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

 */