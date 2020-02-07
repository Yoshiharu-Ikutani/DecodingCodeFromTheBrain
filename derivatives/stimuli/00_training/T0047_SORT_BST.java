public class Main {
  static final int INF = 1000000000;

  public static void main(String[] args) throws Exception {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; ++i)
      a[i] = input.nextInt();
    int swaps = 0;
    for (int i = 0; i < n; ++i) {
      for (int k = n - 1; k > i; --k) {
        if (a[k] < a[k - 1]) {
          int temp = a[k];
          a[k] = a[k - 1];
          a[k - 1] = temp;
          ++swaps;
        }
      }
    }
    System.out.print(a[0]);
    for (int i = 1; i < n; ++i)
      System.out.print(" " + a[i]);
    System.out.println("");
    System.out.println(swaps);
  }
}
