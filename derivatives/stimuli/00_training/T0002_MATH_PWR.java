public class Main {
  static BigInteger function1(BigInteger x, long n) {
    if (n == 0)
      return BigInteger.ONE;
    else if (n == 1)
      return x;
    else if (n % 2 == 0) {
      return function1((x.multiply(x)).remainder(BigInteger.valueOf(1000000007)), n / 2);
    } else {
      return x.multiply(function1((x.multiply(x)).remainder(BigInteger.valueOf(1000000007)), n / 2));
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      BigInteger m = sc.nextBigInteger();
      long n = sc.nextLong();
      m = function1(m, n);
      m = m.remainder(BigInteger.valueOf(1000000007));
      System.out.println(m.toString());
    }
  }
}
