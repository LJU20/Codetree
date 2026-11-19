import java.util.Scanner;

public class Main {
    static int sum, max, k, size, n, m;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        size = 2 * n - 1;
        max = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                def(r, c);
            }
        }
        System.out.println(max);
    }

    static void def(int r, int c) {
        k = 0;
        while (k <= size) {
            sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int nr = r - i;
                    int nc = c - j;
                    if (Math.abs(nr) + Math.abs(nc) <= k) {
                        sum += grid[i][j];
                    }
                }
            }
            int gold = sum * m;
            if (gold >= k * k + (k + 1) * (k + 1)) {
                max = Math.max(max, sum);
            }
            k++;
        }
    }
}
