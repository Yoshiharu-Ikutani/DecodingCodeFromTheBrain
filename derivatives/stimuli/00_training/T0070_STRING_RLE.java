public class Main {
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    while (sc.hasNext()) {
      String s = sc.next();
      String res = "";
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == '@') {
          int rep = s.charAt(i + 1) - '0';
          char b = s.charAt(i + 2);
          for (int j = 0; j < rep; j++)
            res += b;
          i += 2;
        } else {
          res += c;
        }
      }
      System.out.println(res);
    }
  }
}
