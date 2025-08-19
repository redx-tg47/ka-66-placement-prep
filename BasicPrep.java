import java.util.stream.IntStream;

public class BasicPrep {

  public static void main(String[] args) {
    fibonacciSeries(10); // O(n) and O(1)
    reverseNumber(-123); // O(log10(n)) and O(1)
    factorialNumber(5); // O(n) and O(1)
    factorialNumberRecursive(5); // O(n) and O(n) due to recursion stack space
    factorialNumberStream(5); // O(n) and O(1) for the stream operation
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

  public static void factorialNumber(int n) {
    System.out.println("factorial for number " + n);
    int sum = 1;
    for(int i = 1; i <= n ; i++){
      sum *= i;
    }
    System.out.println("factorial is " + sum);
  }

  // using recursion
  public static void factorialNumberRecursive(int n) {
    System.out.println("factorial for number " + n);
    int result = factorialRecursive(n);
    System.out.println("factorial is " + result);
  }

  private static int factorialRecursive(int n) {
    if (n <= 1) {
      return 1;
    }
    return n * factorialRecursive(n - 1); // n * (n-1)
  }

  // using stream
   public static void factorialNumberStream(int n) {
     System.out.println("factorial for number " + n);
     int result = IntStream.rangeClosed(1, n)
       .reduce(1, (a, b) -> a * b);
     System.out.println("factorial is " + result);
   }


}