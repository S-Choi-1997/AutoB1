import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int A, T, CALL;
    public static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        CALL = Integer.parseInt(st.nextToken());

        simulate();
        System.out.println(result);
    }

    public static void simulate() {
        int cycleCount = 2;
        int BBUNCNT = 0; // '뻔' 횟수
        int DAEGICNT = 0; // '데기' 횟수
        int res = 0; // 몇 번째 사람인지 센다
        
        while (true) {
            // 첫 4번은 '뻔' - '데기' - '뻔' - '데기'
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0) {
                    BBUNCNT += 1;
                } else {
                    DAEGICNT += 1;
                }

                // '뻔' 이 특정 번째에 맞다면
                if (BBUNCNT == T && CALL == 0) {
                    result = (res % A);
                    return;
                }
                // '데기' 가 특정번째에 왔다면
                else if (DAEGICNT == T && CALL == 1) {
                    result = (res % A);
                    return;
                }
                res++;
            }

            // n+1 안에서의 반복을 위해 '뻔'과 '데기'의 등장 횟수를 증가
            for (int i = 0; i < cycleCount; i++) {
                BBUNCNT += 1;
                if (BBUNCNT == T && CALL == 0) {
                    result = (res % A);
                    return;
                }
                res++;
            }

            for (int i = 0; i < cycleCount; i++) {
                DAEGICNT += 1;
                if (DAEGICNT == T && CALL == 1) {
                    result = (res % A);
                    return;
                }
                res++;
            }
            cycleCount += 1;
        }
    }
}