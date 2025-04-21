import java.io.*;
import java.util.PriorityQueue;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < N; i++){
            int input = Integer.parseInt(br.readLine());
            if(input > 0){
                pq.add(input);
            } else {
                if(!pq.isEmpty()){
                    bw.write(pq.poll() + "\n");
                } else {
                    bw.write(0 + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}