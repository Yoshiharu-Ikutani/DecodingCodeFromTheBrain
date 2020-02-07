public class Main {
  public static final long mod7 = 1000000007L;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long n = sc.nextLong();
    long m = sc.nextLong();
    System.out.println(function1(n, m, mod7));
  }

  public static long function1(long n, long k, long mod) {
    if (k == 0) {
      return 1;
    }
    if (k % 2 == 0) {
      long t = function1(n, k / 2, mod);
      return ((t % mod) * (t % mod)) % mod;
    }
    return n * function1(n, k - 1, mod) % mod;
  }
}
