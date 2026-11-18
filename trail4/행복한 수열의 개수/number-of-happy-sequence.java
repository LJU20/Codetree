import java.util.Scanner;

public class Main {
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int[][] gridT = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                gridT[i][j] = grid[j][i];

        int res = 0;
        res += check(grid) + check(gridT);
        System.out.println(res);

    }
    static int check(int[][] grid) {
        if (m == 1) return n;
        int result = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            boolean pass = false;
            for (int j = 0; j < n - 1; j++) {
                if (grid[i][j] == grid[i][j + 1]) cnt++;
                else cnt = 0;
                if (cnt == m - 1) pass= true;
            }
            if(pass) result++;
        }
        
        return result;
    }
}
