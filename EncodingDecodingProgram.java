import java.util.Base64;
import java.util.Scanner;

public class EncodingDecodingProgram {

    // Caesar Cipher Encoding
    public static String caesarCipherEncode(String text, int shift) {
        StringBuilder encoded = new StringBuilder();
        for (char charAt : text.toCharArray()) {
            if (Character.isLetter(charAt)) {
                char base = Character.isUpperCase(charAt) ? 'A' : 'a';
                encoded.append((char) ((charAt - base + shift) % 26 + base));
            } else {
                encoded.append(charAt);
            }
        }
        return encoded.toString();
    }

    // Caesar Cipher Decoding
    public static String caesarCipherDecode(String text, int shift) {
        return caesarCipherEncode(text, -shift);
    }

    // Base64 Encoding
    public static String base64Encode(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    // Base64 Decoding
    public static String base64Decode(String encodedData) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedData);
        return new String(decodedBytes);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose encoding method (1: Caesar Cipher, 2: Base64): ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character
        
        if (choice == 1) {
            // Caesar Cipher encoding/decoding
            System.out.println("Enter text for Caesar Cipher encoding:");
            String text = scanner.nextLine();
            System.out.println("Enter shift value:");
            int shift = scanner.nextInt();

            String encodedText = caesarCipherEncode(text, shift);
            System.out.println("Encoded Text: " + encodedText);

            String decodedText = caesarCipherDecode(encodedText, shift);
            System.out.println("Decoded Text: " + decodedText);
        } else if (choice == 2) {
            // Base64 encoding/decoding
            System.out.println("Enter text for Base64 encoding:");
            String text = scanner.nextLine();

            String encodedText = base64Encode(text);
            System.out.println("Base64 Encoded Text: " + encodedText);

            String decodedText = base64Decode(encodedText);
            System.out.println("Base64 Decoded Text: " + decodedText);
        } else {
            System.out.println("Invalid choice.");
        }
    }
}

