public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] str = (br.readLine()).split(" ");
    int[] a = new int[n];
    int cnt = 0;
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(str[i]);
    for (int i = 0; i < n; i++) {
      int minj = i;
      for (int j = i; j < n; j++) {
        if (a[j] < a[minj]) {
          minj = j;
        }
      }
      if (a[i] != a[minj]) {
        int tmp = a[i];
        a[i] = a[minj];
        a[minj] = tmp;
        cnt++;
      }
    }
    for (int i = 0; i < n; i++) {
      if (i != n - 1)
        System.out.print(a[i] + " ");
      else
        System.out.println(a[i]);
    }
    System.out.println(cnt);
  }
}
