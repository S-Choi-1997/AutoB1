import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_2015번_수들의합4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        long[] arr = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i - 1] + Long.parseLong(st.nextToken());
        }

        long result = 0L;
        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);

        for (int i = 1; i <= N; i++) {
            result += map.getOrDefault(arr[i] - K, 0L);
            map.put(arr[i], map.getOrDefault(arr[i], 0L) + 1);
        }

        System.out.println(result);
    }
}