import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] check = new int[11]; // 1~10의 소 번호를 위한 크기
        for (int i = 1; i <= 10; i++) {
            check[i] = -1; // 초깃값 설정
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken());
            int position = Integer.parseInt(st.nextToken());

            if (check[cow] == -1) {
                check[cow] = position;
            } else if (check[cow] != position) {
                total++;
                check[cow] = position;
            }
        }
        System.out.println(total);
    }
}