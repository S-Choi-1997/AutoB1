public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        char[] board = input.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < board.length; ) {
            if (i + 3 < board.length && board[i] == 'X' && board[i + 1] == 'X' && board[i + 2] == 'X' && board[i + 3] == 'X') {
                sb.append("AAAA");
                i += 4;
            } else if (i + 1 < board.length && board[i] == 'X' && board[i + 1] == 'X') {
                sb.append("BB");
                i += 2;
            } else if (board[i] == '.') {
                sb.append(".");
                i++;
            } else {
                sb = new StringBuilder("-1");
                break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}