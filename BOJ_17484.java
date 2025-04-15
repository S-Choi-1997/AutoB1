import java.io.*;
import java.util.*;

class Main{    
    static int n,m;
    static int arr[][];
    static int min = Integer.MAX_VALUE;
    static int[] dy = {-1, 0, 1};
    static int[] visit;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<m; i++) {
            visit = new int[n];
            visit[0] = i;
            brute(1, i, -1);
        }

        System.out.println(min);
    }

    public static void brute(int layer, int y, int dir) {
        if(layer == n) {
            int sum = 0;
            for(int i=0; i<n; i++) {
                sum += arr[i][visit[i]];
            }
            min = Math.min(min, sum);
            return;
        }

        for(int i=0; i<3; i++) {
            int nowy = y + dy[i];
            if(position(nowy) && dir != i) {
                visit[layer] = nowy;
                brute(layer+1, nowy, i);
            }
        }
    }

    public static boolean position(int y) {
        return y >= 0 && y < m;
    }
}