import java.util.Scanner;

public class StockMaximization2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int t=0; t<T; t++) {
            int N = input.nextInt();
            int[] A = new int[N];
            for (int n=0; n<N; n++) {
                A[n] = input.nextInt();
            }
            
            
            boolean[] buy = new boolean[N];
            int max = A[N-1];
            for (int n=N-2; n>=0; n--) {
                int value = A[n];
                if (value > max) {
                    max = value;
                } else {
                    buy[n] = true;
                }
            }
            long money = 0;
            long stock = 0;
            for (int n=0; n<N; n++) {
                if (buy[n]) {
                    money -= A[n];
                    stock++;
                } else {
                    money += stock*A[n];
                    stock = 0;
                }
            }
            System.out.println(money);
        }
    }
    
}
