public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] S = new int[n];
    for (int i = 0; i < n; i++) {
      S[i] = scanner.nextInt();
    }
    int q = scanner.nextInt();
    int[] T = new int[q];
    for (int i = 0; i < q; i++) {
      T[i] = scanner.nextInt();
    }
    int cnt = 0;
    for (int i : T) {
      for (int j : S) {
        if (i == j) {
          cnt++;
          break;
        }
      }
    }
    System.out.println(cnt);
  }
}
