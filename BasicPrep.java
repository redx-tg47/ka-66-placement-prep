public class BasicPrep {

  public static void main(String[] args) {
    fibonacciSeries(10); // O(n) and O(1)
    reverseNumber(-123); // O(log10(n)) and O(1)
  }

  // What is fibonacciSeries?
  // A series of numbers where each number is the sum of the two preceding ones,
  // usually starting with 0 and 1
  public static void fibonacciSeries(int n) {
    int a = 0;
    int b = 1;
    System.out.print("Fibonacci Series: " + a + ", " + b);

    for (int i = 2; i < n; i++) {
      int next = a + b;
      System.out.print(", " + next);
      a = b;
      b = next;
    }

    System.out.println();
  }

  public static void reverseNumber(int n) {
    System.out.println("original number " + n);
    int reverse = 0;
    int isNegative = n < 0 ? -1 : 1; // Check if the number is negative
    n = Math.abs(n); // Make n positive for reversal

    while(n > 0) {
      int digit = n % 10;
      reverse = reverse * 10 + digit;
      n /=10;
    }

    reverse *= isNegative; // Restore the sign if it was negative
    System.out.println("reversed number " + reverse);
  }

}