public class Main {
  static int n;
  static HashSet<Integer> S = new HashSet<Integer>();;
  static int q;
  static int t;
  static int count;

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    String[] temp = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      S.add(Integer.parseInt(temp[i]));
    }
    q = Integer.parseInt(br.readLine());
    temp = br.readLine().split(" ");
    for (int i = 0; i < q; i++) {
      t = Integer.parseInt(temp[i]);
      function1(t);
    }
    System.out.println(count);
  }

  public static void function1(int num) {
    if (S.contains(num)) {
      count++;
      return;
    }
  }
}
