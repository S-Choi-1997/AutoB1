import java.util.*;
import java.io.*;

public class Main {
   
    static int N;
    static int[] NUMBERS;

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        NUMBERS = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            NUMBERS[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        boolean[] checked = new boolean[100001];
        int L = 1, R = 1;
        long ans = N * (N + 1) / 2; // 모든 연속 부분수열의 개수
        
        while(R <= N) {
            if (!checked[NUMBERS[R]]) {
                checked[NUMBERS[R]] = true;
                R++;
            } else {
                checked[NUMBERS[L]] = false;
                ans -= (N - R + 1);
                L++;
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}