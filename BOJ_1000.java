Here is the consolidated code which combines the code from blog 2:

```java
// Code using Scanner
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int a = kb.nextInt();
        int b = kb.nextInt();

        System.out.println(a+b);

        kb.close();
    }
}

// Code using BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
		
        System.out.print(a+b); 
        
        br.close();
    }
}
```

Please note that you cannot have two classes with the same name (in this case `Main`) in the same file unless one of them is nested within the other. Hence you need to rename one of the classes or put them in separate files. The code logic will not be changed, only the class names are needed to be changed.