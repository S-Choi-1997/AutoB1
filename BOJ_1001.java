import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    
    public static void main( String[] args ) throws IOException {
        
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        
        String[] Str = br.readLine().split( " " );
        int A = Integer.parseInt( Str[0] );
        int B = Integer.parseInt( Str[1] );
        
        System.out.println( A-B );
    }
}