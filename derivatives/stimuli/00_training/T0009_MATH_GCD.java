public class Main {
  static String a;

  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    int x = stdIn.nextInt();
    int y = stdIn.nextInt();
    if (x < y) {
      int tmp = x;
      x = y;
      y = tmp;
    }
    int ans = function1(x, y);
    System.out.println(ans);
  }

  public static int function1(int x, int y) {
    if (x == 0)
      return y;
    if (x == y)
      return x;
    return function1(y % x, x);
  }
}
