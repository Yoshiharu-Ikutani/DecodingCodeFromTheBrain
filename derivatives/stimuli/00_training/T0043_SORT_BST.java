public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] ar = new int[N];
    for (int i = 0, j; i < N; i++) {
      ar[i] = sc.nextInt();
    }
    int cnt = 0;
    for (int i = 0; i < N; i++) {
      for (int j = N - 1; j > i; j--) {
        if (ar[j] < ar[j - 1]) {
          ar[j - 1] -= ar[j];
          ar[j] += ar[j - 1];
          ar[j - 1] = ar[j] - ar[j - 1];
          cnt++;
        }
      }
    }
    for (int i = 0; i < N - 1; i++) {
      System.out.print(ar[i] + " ");
    }
    System.out.println(ar[N - 1]);
    System.out.println(cnt);
  }
}
