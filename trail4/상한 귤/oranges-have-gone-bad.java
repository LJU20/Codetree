import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] grid, arr;
    static int n, k;
    static Queue<int[]> q;
    static ArrayList<int[]> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        list = new ArrayList<>();
        q = new ArrayDeque<>();

        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        arr = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 2) list.add(new int[] {i, j});
            }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) arr[i][j] = -1;
            }
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
                if (j == n - 1) System.out.println();
            }
        }

    }
    static void bfs() {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int[] cur = list.get(i);
            int x = cur[0];
            int y = cur[1];
            q.offer(new int[] {x, y});
            arr[x][y] = -3;
        }

        int time = 0;

        while (!q.isEmpty()) {
            time++;
            size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int cr = cur[0];
                int cc = cur[1];

                for (int d = 0; d < 4; d++) {
                    int nr = cr + dr[d];
                    int nc = cc + dc[d];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                    if (grid[nr][nc] == 0) continue;
                    if (grid[nr][nc] == 1) {
                        q.offer(new int[] {nr, nc});
                        arr[nr][nc] = time;
                        grid[nr][nc] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {


                if (arr[i][j] == 0) arr[i][j] = -2;
                else if (arr[i][j] == -3) arr[i][j] = 0;
            }
        }
    }
}
