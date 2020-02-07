public class Main {
  public static void main(String[] args) {
    new Main().function1();
  }

  Scanner sc = new Scanner(System.in);
  long m, n;
  long INF = 1000000007;

  void function1() {
    while (sc.hasNext()) {
      m = sc.nextLong();
      n = sc.nextLong();
      if (m != 0 && n != 0)
        System.out.println(function2(m, n) % INF);
    }
  }

  long function2(long m, long n) {
    if (n == (long) 0)
      return (long) 1;
    long a = function2(m, n / (long) 2);
    if (a > INF)
      a = a % INF;
    a = (a * a);
    if (a > INF)
      a = a % INF;
    if (n % (long) 2 != (long) 0) {
      a = (a * m) % INF;
    }
    return a;
  }
}
