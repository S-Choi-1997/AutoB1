import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> people = new HashSet<>();
        for (int i = 0; i < N; i++)
            people.add(br.readLine());

        List<String> result = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (people.contains(name)) result.add(name);
        }

        Collections.sort(result);
        bw.write(result.size() + "\n");
        for(String str : result) {
            bw.write(str);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}