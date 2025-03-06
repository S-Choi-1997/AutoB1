import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        char[][] cArr = new char[H][W];
        
        for (int i = 0; i < H; i++) {
            String str = br.readLine();
            for (int j = 0; j < W; j++) {
                cArr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < H; i++) {
            int time = 0;
            for (int j = 0; j < W; j++) {
                if (cArr[i][j] == 'c') {
                    time = 1;
                    bw.write("0 ");
                } else if (cArr[i][j] == '.') {
                    if (time == 0) {
                        bw.write("-1 ");
                    } else {
                        bw.write(time + " ");
                        time++;
                    }
                }
            }
            bw.write("\n");
        }

        bw.flush();
    }
}