public class BasicPrep {

  public static void main(String[] args) {
    fibonacciSeries(10);
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

}