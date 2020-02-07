public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      if (function1(sc.nextInt()))
        cnt++;
    }
    System.out.println(cnt);
  }

  static boolean function1(int tmp) {
    if (tmp == 2 || tmp == 3 || tmp == 5 || tmp == 7)
      return true;
    if (tmp % 2 == 0)
      return false;
    for (int i = 3; i <= Math.sqrt(tmp); i++) {
      if (tmp % i == 0)
        return false;
    }
    return true;
  }
}
