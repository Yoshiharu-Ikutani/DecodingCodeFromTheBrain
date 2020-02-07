public class Main {
  public static void main(String[] str) throws java.io.IOException {
    final int s_maxsize = 10000;
    final int q_maxsize = 10000;
    String buf;
    int[] s = new int[s_maxsize];
    int[] t = new int[q_maxsize];
    int ans = 0;
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    for (int i = 0; i < n; i++) {
      s[i] = scan.nextInt();
    }
    int q = scan.nextInt();
    for (int i = 0; i < q; i++) {
      t[i] = scan.nextInt();
    }
    for (int i = 0; i < q; i++) {
      for (int j = 0; j < n; j++) {
        if (s[j] == t[i]) {
          ans += 1;
          break;
        }
      }
    }
    System.out.println(ans);
  }
}
