import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1913 {
    static int[] dr = {1, 0, -1, 0}; // 하, 우, 상, 좌
    static int[] dc = {0, 1, 0, -1};
    static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int kr = 0;
        int kc = 0;

        makeMap(n);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sb.append(map[i][j]).append(" ");
                if(map[i][j] == k) {
                    kr = i;
                    kc = j;
                }
            }
            sb.append("\n");
        }
        sb.append(kr + 1).append(" ").append(kc + 1);
        System.out.println(sb);
    }

    public static void makeMap(int n) {
        int r = n / 2;
        int c = n / 2;
        int value = 1;
        int limit = 1;
        int output = 0;

        while(true) {
            for(int i = 0; i < limit; i++) {
                if(value > n * n) return;
                map[r--][c] = value++;
            }
            for(int i = 0; i < limit; i++) {
                if(value > n * n) return;
                map[r][c++] = value++;
            }
            limit++;
            for(int i = 0; i < limit; i++) {
                if(value > n * n) return;
                map[r++][c] = value++;
            }
            for(int i = 0; i < limit; i++) {
                if(value > n * n) return;
                map[r][c--] = value++;
            }
            limit++;
        }
    }
}