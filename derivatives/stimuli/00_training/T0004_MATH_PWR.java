public class Main {
  static long divNum = 1000000007;

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String[] tmp = s.nextLine().split(" ");
    long m = Long.parseLong(tmp[0]);
    long n = Long.parseLong(tmp[1]);
    System.out.println(function1(m, n));
  }

  public static long function1(long m, long n) {
    if (n == 1)
      return m;
    if (n % 2 == 0)
      return function1(((m * m % divNum)), n / 2);
    else
      return ((function1(m * m % divNum, n / 2) * m) % divNum);
  }
}
