public class Main {

  int INF = 1 << 28;

  void function1() {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      String str = sc.next(), ans = "";
      for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) == '@') {
          i++;
          int n = str.charAt(i++) - '0';
          for (int j = 0; j < n; j++)
            ans += str.charAt(i);
        } else {
          ans += str.charAt(i);
        }
      }
      System.out.println(ans);
    }
  }

  public static void main(String[] args) {
    new Main().function1();
  }
}
