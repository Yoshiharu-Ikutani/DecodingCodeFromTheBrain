class Main {
  static long mod = 1000000007;

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = "";
    while ((s = br.readLine()) != null) {
      String[] a = s.split(" ");
      Long x = Long.parseLong(a[0]);
      Long y = Long.parseLong(a[1]);
      System.out.println(function1(x, y));
    }
  }

  public static long function1(long b, long p) {
    if (p == 0) {
      return 1;
    } else if (p % 2 == 0) {
      long result = function1(b, p / 2);
      return ((result % mod) * (result % mod)) % mod;
    } else {
      long result = function1(b, p - 1);
      return ((b % mod) * (result % mod)) % mod;
    }
  }
}
