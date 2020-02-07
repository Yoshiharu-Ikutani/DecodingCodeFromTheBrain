public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i <= n - 1; i++) {
        a[i] = sc.nextInt();
      }
      for (int k = 0; k <= n - 2; k++) {
        System.out.print(a[k] + " ");
      }
      System.out.println(a[n - 1]);
      for (int i = 1; i <= n - 1; i++) {
        int v = a[i];
        int j = i - 1;
        while (j >= 0 && a[j] > v) {
          a[j + 1] = a[j];
          j--;
          a[j + 1] = v;
        }
        for (int k = 0; k <= n - 2; k++) {
          System.out.print(a[k] + " ");
        }
        System.out.println(a[n - 1]);
      }
    }
  }
}
