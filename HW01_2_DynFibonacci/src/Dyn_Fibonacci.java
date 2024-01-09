import java.util.Scanner;

public class Dyn_Fibonacci {
    final static int max_n = 1000;
    static double[] fb_n_tbl = new double[max_n];
    static boolean fb_n_tbl_initialized = false;

    public static double Dyn_Fibonacci(int n) {
        if(fb_n_tbl_initialized == false) {
            for(int i=0; i<max_n; i++)
                fb_n_tbl[i] = 0;
            fb_n_tbl_initialized = true;
        }
        if(fb_n_tbl[n] != 0) {
            return fb_n_tbl[n];
        } else if ((n==1) || (n==0)) {
            fb_n_tbl[n] = n;
            return n;
        } else {
            double fb_n = Dyn_Fibonacci(n-2) + Dyn_Fibonacci(n-1);
            fb_n_tbl[n] = fb_n;
            return fb_n;
        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n;
        double fibo_n;
        long t1, t2, elapsed_time_ms;
        while(true) {
            System.out.print("input n (>=0) to find 0 ~ nth fibo_n (-1 to terminate):");
            n = cin.nextInt();
            if(n == -1)
                break;
            t1 = System.currentTimeMillis();
            for(int i=0; i<=n; i++) {
                fibo_n = Dyn_Fibonacci(i);
                System.out.printf("%3d-th Fibonacci Series = %25.0f\n", i, fibo_n);
            }
            t2 = System.currentTimeMillis();
            elapsed_time_ms = t2-t1;
            System.out.printf("Dyn_Fibonacci took %d milliseconds\n", elapsed_time_ms);
        }
        cin.close();
    }
}

