public class TrianglePrinter {

    public static void printInverted(int n) {
        if (n <= 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();
        printInverted(n - 1);
    }

    public static void printTriangle(int n) {
        if (n <= 0) {
            return;
        }
        printTriangle(n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Inverted Triangle:");
        printInverted(5);

        System.out.println("\nRegular Triangle:");
        printTriangle(5);
    }
}
