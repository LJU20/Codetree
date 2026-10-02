import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int r, c;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<int[]> waterQ = new ArrayDeque<>();
        waterQ.offer(new int[] { 0, 0 });
        Queue<int[]> glacierQ = new ArrayDeque<>();
        visited = new boolean[r][c];
        visited[0][0] = true;
        int cnt = 0;
        int time = 0;

        while (check()) {
            cnt = 0;
            time++;
            while (!waterQ.isEmpty()) {
                int[] cur = waterQ.poll();
                int cr = cur[0];
                int cc = cur[1];

                for (int d = 0; d < 4; d++) {
                    int nr = cr + dr[d];
                    int nc = cc + dc[d];

                    if (nr < 0 || nr >= r || nc < 0 || nc >= c)
                        continue;
                    if(visited[nr][nc]) continue;
                    
                    if (map[nr][nc] == 0) {
                        waterQ.offer(new int[] { nr, nc });
                        visited[nr][nc] = true;
                    }
                    if(map[nr][nc] == 1) {
                        glacierQ.offer(new int[] {nr, nc});
                        visited[nr][nc] = true;
                    }
                    
                }
            }

            while(!glacierQ.isEmpty()) {
                int[] cur = glacierQ.poll();
                int cr = cur[0];
                int cc = cur[1];
                map[cr][cc] = 0;
                waterQ.offer(new int[] {cr, cc});
                cnt++;
            }
        }
        System.out.printf("%d %d", time, cnt);
    }

    private static boolean check() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
