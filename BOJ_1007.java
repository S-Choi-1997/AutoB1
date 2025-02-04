import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 0; i < N; i++) {
            String input = scanner.nextLine();
            try {
                System.out.println(HexConverter.hexToDecimal(input));
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + "HEXADECIMAL 값을 읽을 수 없습니다.");
            }
        }
    }
}

class HexConverter {
    public static int hexToDecimal(String hexadecimal) {
        if (hexadecimal == null || hexadecimal.trim().isEmpty()) {
            throw new NumberFormatException("Invalid hexadecimal value: ");
        }
        
        String processedHex = hexadecimal.trim().replaceFirst("^0x|^0X", "").toUpperCase();
        
        if (processedHex.length() == 0) {
            throw new NumberFormatException("Empty value after processing: ");
        }
        
        if (!processedHex.matches("[0-9A-F]+")) {
            throw new NumberFormatException("Contains invalid characters: " + hexadecimal + " ");
        }
        
        try {
            return Integer.parseInt(processedHex, 16);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Parsing failed: ");
        }
    }
}