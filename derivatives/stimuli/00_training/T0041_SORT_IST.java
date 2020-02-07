public class Main {
  public static void main(String[] args) {
    int n, i, j, v;
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    int m[] = new int[n];
    int k[] = new int[n];
    for (i = 0; i < m.length; i++) {
      m[i] = scan.nextInt();
    }
    for (i = 0; i < m.length - 1; i++) {
      System.out.print(m[i] + " ");
    }
    System.out.println(m[n - 1]);
    for (i = 1; i <= m.length - 1; i++) {
      v = m[i];
      j = i - 1;
      while (j >= 0 && m[j] > v) {
        m[j + 1] = m[j];
        j--;
      }
      m[j + 1] = v;
      for (j = 0; j < m.length - 1; j++) {
        System.out.print(m[j] + " ");
      }
      System.out.println(m[n - 1]);
    }
  }
}
