package beeCrowd.add.hoc;

import java.util.Scanner;
public class ALendaDeFlaviousJosephus {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int caso = 1;

        int casos = sc.nextInt();

        for (int i = 0; i < casos; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            System.out.println("Case " + caso + ": " + (josephus(n, k) + 1));
            caso++;
        }
    }

    static int josephus(int n, int k) {
        if (n == 1) return 0;

        return (josephus(n - 1, k) + k) % n;
    }
}
