public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    String[] elements = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(elements[i]);
    }
    int swap = 0;
    for (int i = 0; i < a.length - 1; i++) {
      for (int j = a.length - 1; j >= i + 1; j--) {
        if (a[j] < a[j - 1]) {
          int v = a[j - 1];
          a[j - 1] = a[j];
          a[j] = v;
          swap++;
        }
      }
    }
    System.out.print(a[0]);
    if (n > 1) {
      for (int i = 1; i < a.length; i++) {
        System.out.print(" " + a[i]);
      }
    }
    System.out.println();
    System.out.println(swap);
  }
}
