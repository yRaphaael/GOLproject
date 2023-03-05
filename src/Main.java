import java.util.Scanner;

public class Main {
    Scanner ler = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException {
        String [] txtw = args[0].split("=");
        int w = Integer.parseInt(txtw[1]);
        String [] txth = args[1].split("=");
        int h = Integer.parseInt(txth[1]);
        String [] txtg = args[2].split("=");
        int g = Integer.parseInt(txtg[1]);
        String [] txts = args[3].split("=");
        int s = Integer.parseInt(txts[1]);
        String [] txtp = args[4].split("=");
        String p = txtp[1];
        Initialize go = new Initialize(w,h,g,s,p);
        go.initialize();

    }
}
