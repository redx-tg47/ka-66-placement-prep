import java.util.Arrays;
import java.util.stream.IntStream;

public class BasicPrep {

  public static void main(String[] args) {
    fibonacciSeries(10); // O(n) and O(1)
    reverseNumber(-123); // O(log10(n)) and O(1)

    sumOfDigits(12345); // O(log10(n)) and O(1)

    // Factorial Numbers
    factorialNumber(5); // O(n) and O(1)
    factorialNumberRecursive(5); // O(n) and O(n) due to recursion stack space
    factorialNumberStream(5); // O(n) and O(1) for the stream operation

    // Factors of a Number
    printFactors(12); // O(n) and O(1)
    printFactorsStreams(12); // O(n) and O(1) for the stream operation

    isNumberArmstrong(153); // O(log10(n)) and O(1)

    areStringAnagram("listen", "silent"); // O(n log n) and O(n) for sorting and space

    // Star Patterns
    printStarPatterns(5);  // O(n^2) and O(1)
    printStarPatterns1(5); // O(n^2) and O(1)
    printStarPatterns2(5); // O(n^2) and O(1)
    printStarPatterns3(2); // O(n^2) and O(1)
    printStarPatterns4(5); // O(n^2) and O(1)
    printStarPatterns5(5); // O(n^2) and O(1)
    printStarPatterns6(5); // O(n^2) and O(1)
    printStarPattern7(5);  // O(n^2) and O(1)
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

    while (n > 0) {
      int digit = n % 10;
      reverse = reverse * 10 + digit;
      n /= 10;
    }

    reverse *= isNegative; // Restore the sign if it was negative
    System.out.println("reversed number " + reverse);
  }


  public static void sumOfDigits(int n) {
    int sum = 0;

    while(n > 0) {
      int r = n % 10;
      sum += r;
      n /= 10;
    }
    System.out.println(sum);
  }

  public static void factorialNumber(int n) {
    System.out.println("factorial for number " + n);
    int sum = 1;
    for (int i = 1; i <= n; i++) {
      sum *= i;
    }
    System.out.println("factorial is " + sum);
  }

  // using recursion
  public static void factorialNumberRecursive(int n) {
    System.out.println("Using recursion factorial for number " + n);
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
    System.out.println("Using Stream Operation factorial for number " + n);
    int result = IntStream.rangeClosed(1, n)
        .reduce(1, (a, b) -> a * b);
    System.out.println("factorial is " + result);
  }

  // factors of Number
  public static void printFactors(int n) {
    System.out.print("Factors of " + n + ": ");
    for (int i = 1; i <= n; i++) {
      if (n % i == 0) {
        System.out.print(i + " ");
      }
    }
    System.out.println();
  }

  public static void printFactorsStreams(int n) {
    System.out.print("Using stream operations factors of " + n + ": ");
    IntStream.rangeClosed(1, n)
        .filter(i -> n % i == 0)
        .forEach(i -> System.out.print(i + " "));
    System.out.println();
  }

  public static void isNumberArmstrong(int n) {
    int original = n;
    int sum = 0;

    while(n > 0) {
      int d = n % 10;
      sum += d * d * d;
      n /= 10;
    }

    if(sum == original){
      System.out.println("Given Number is Amstrong");
    } else {
      System.out.println("Given Number is not Amstrong");
    }
  }

  public static void areStringAnagram(String s1, String s2) {
    char [] a = s1.toCharArray();
    char [] b = s2.toCharArray();

    Arrays.sort(a);
    Arrays.sort(b);

    if (Arrays.equals(a,b)){
      System.out.println("Given Strings are Anagram");
    } else {
      System.out.println("Given Strings are not Anagram");
    }
  }


  // Star Patterns
  // This method prints a right-angled triangle pattern of stars
  public static void printStarPatterns(int n) {
    System.out.println("***** Star Pattern *****");
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  // This method prints an inverted right-angled triangle pattern of stars
  public static void printStarPatterns1(int n) {
    System.out.println("Star Pattern 1");
    for (int i = n; i >= 1; i--) {
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  // This method prints a pyramid pattern of stars
  public static void printStarPatterns2(int n) {
    System.out.println("Star Pattern 2");

    for (int i = 1; i <= n; i++) {
      for (int j = n; j > i; j--) {
        System.out.print(" ");
      }
      for (int k = 1; k <= (2 * i - 1); k++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  // This method prints a diamond pattern of stars
  public static void printStarPatterns3(int n) {
    System.out.println("Star Pattern 3");

    // Upper part of the diamond
    for (int i = 1; i <= n; i++) {
      for (int j = n; j > i; j--) {
        System.out.print(" ");
      }
      for (int k = 1; k <= (2 * i - 1); k++) {
        System.out.print("*");
      }
      System.out.println();
    }

    // Lower part of the diamond
    for (int i = n - 1; i >= 1; i--) {
      for (int j = n; j > i; j--) {
        System.out.print(" ");
      }
      for (int k = 1; k <= (2 * i - 1); k++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  // This method prints a diamond pattern of stars with inverted alignment
  public static void printStarPatterns4(int n) {
    System.out.println("Star Pattern 4");

    // Upper part of the diamond
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j < i; j++) {
        System.out.print(" ");
      }
      for (int k = 1; k <= (2 * (n - i) + 1); k++) {
        System.out.print("*");
      }
      System.out.println();
    }

    // Lower part of the diamond
    for (int i = n - 1; i >= 1; i--) {
      for (int j = 1; j < i; j++) {
        System.out.print(" ");
      }
      for (int k = 1; k <= (2 * (n - i) + 1); k++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }


  // This method prints a diamond pattern of stars with right alignment
  public static void printStarPatterns5(int n) {
    System.out.println("Star Pattern 5");

    // Upper part of the diamond
    for (int i = 1; i <= n; i++) {
      for (int j = n; j > i; j--) {
        System.out.print(" ");
      }
      for (int k = 1; k <= i; k++) {
        System.out.print("*");
      }
      System.out.println();
    }

    // Lower part of the diamond
    for (int i = n; i >= 1; i--) {
      for (int j = n; j > i; j--) {
        System.out.print(" ");
      }
      for (int k = 1; k <= i; k++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }


  // This method prints a hollow square pattern of stars
  public static void printStarPatterns6(int n) {
    System.out.println("Star Pattern 6");

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (i == 1 || i == n || j == 1 || j == n) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }


  public static void printStarPattern7(int n) {
    System.out.println("Star Pattern 7");

    // Upper part of the pattern
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }

    // Lower part of the pattern
    for (int i = n - 1; i >= 1; i--) {
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }


}