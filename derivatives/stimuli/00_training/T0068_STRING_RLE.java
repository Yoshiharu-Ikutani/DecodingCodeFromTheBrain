public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    while (sc.hasNext()) {
      String str = sc.next();
      String str2 = "";

      for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) == '@') {
          i++;
          int n = str.charAt(i) - '0';
          i++;
          for (int j = 0; j < n; j++) {
            str2 += str.charAt(i);
          }
        } else {
          str2 += str.charAt(i);
        }
      }
      System.out.println(str2);
    }
  }
}
