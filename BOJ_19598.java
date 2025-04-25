import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Node[] meeting = new Node[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meeting[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(meeting);

        PriorityQueue<Integer> room = new PriorityQueue<>();
        room.offer(meeting[0].end);

        for (int i = 1; i < N; i++) {
            if (meeting[i].start >= room.peek()) {
                room.poll();
            }
            room.offer(meeting[i].end);
        }

        System.out.println(room.size());
    }
}

class Node implements Comparable<Node> {
    int start, end;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Node next) {
        if (this.start == next.start) {
            return this.end - next.end;
        } else {
            return this.start - next.start;
        }
    }
}