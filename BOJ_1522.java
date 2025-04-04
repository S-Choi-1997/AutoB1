import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int aCount = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a') aCount++;
        }

        if(aCount == 0) {
            System.out.println(0);
            return;
        }

        int minChanges = Integer.MAX_VALUE;
        int bCount = 0;

        for (int i = 0; i < aCount; i++) {
            if(s.charAt(i) == 'b') bCount++;
        }

        minChanges = Math.min(minChanges, bCount);

        for (int i = aCount; i < s.length() + aCount; i++) {
            int start = (i - aCount) % s.length();
            int end = i % s.length();

            if(s.charAt(start) == 'b') bCount--;
            if(s.charAt(end) == 'b') bCount++;

            minChanges = Math.min(minChanges, bCount);
        }

        System.out.println(minChanges);
    }
}