import java.util.Scanner;
public class Main {
    static int[][] grid;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int result = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                result = Math.max(result, mul(i, j, 3));
            }
        }
        System.out.println(result);
    }
    static int mul(int r, int c, int num) {
        int coin = 0;
        for (int i = r; i < r + num; i++) {
            for (int j = c; j < c + num; j++) {
                coin += grid[i][j];
            }
        }
        return coin;
    }
}
