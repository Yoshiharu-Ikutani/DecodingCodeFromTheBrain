public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] S = new int[n];
    for (int i = 0; i < n; i++) {
      S[i] = sc.nextInt();
    }
    int q = sc.nextInt();
    int[] T = new int[q];
    for (int i = 0; i < q; i++) {
      T[i] = sc.nextInt();
    }
    int count = 0;
    for (int i = 0; i < T.length; i++) {
      int t = T[i];
      int l = -1;
      int u = S.length;
      while (u - l > 1) {
        int m = (u + l) / 2;
        if (t == S[m]) {
          count++;
          break;
        } else if (t < S[m]) {
          u = m;
        } else {
          l = m;
        }
      }
    }
    System.out.println(count);
  }
}
