import java.util.Scanner;

public class Main {
    static int[][] grid;
    static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        max = Integer.MIN_VALUE;
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                sum1(i, j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 2; j++) {
                sum2(i, j);
            }
        }
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m; j++) {
                sum3(i, j);
            }
        }
        System.out.println(max);
    }

    static void sum1(int r, int c) {
        max = Math.max(max, grid[r][c] + grid[r][c + 1] + grid[r + 1][c]);
        max = Math.max(max, grid[r][c] + grid[r][c + 1] + grid[r + 1][c + 1]);
        max = Math.max(max, grid[r][c] + grid[r + 1][c] + grid[r + 1][c + 1]);
        max = Math.max(max, grid[r][c + 1] + grid[r + 1][c] + grid[r + 1][c + 1]);
    }
    static void sum2(int r, int c) {
        max = Math.max(max, grid[r][c] + grid[r][c + 1] + grid[r][c + 2]);
    }
    static void sum3(int r, int c) {
        max = Math.max(max, grid[r][c] + grid[r + 1][c] + grid[r + 2][c]);
    }

}
