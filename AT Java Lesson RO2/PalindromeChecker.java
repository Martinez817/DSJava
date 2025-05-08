public class PalindromeChecker {

    public static String clean(String text) {
        return text.toLowerCase().replaceAll("[^a-z]", "");
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] testCases = {
            "Madam, I’m Adam",
            "Kayak",
            "Hello, world!",
            "A man, a plan, a canal, Panama"
        };

        for (String original : testCases) {
            String cleaned = clean(original);
            System.out.println("Original: " + original);
            System.out.println("Recursive: " + isPalindromeRecursive(cleaned));
            System.out.println("Iterative: " + isPalindromeIterative(cleaned));
            System.out.println();
        }
    }
}
