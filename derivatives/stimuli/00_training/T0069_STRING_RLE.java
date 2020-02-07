public class Main {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    while (stdIn.hasNext()) {
      String k = stdIn.next();
      String tmp = "";

      for (int i = 0; i < k.length(); i++) {
        if (k.charAt(i) == '@') {
          int ck = Integer.parseInt(String.valueOf(k.charAt(i + 1)));
          String cl = String.valueOf(k.charAt(i + 2));
          for (int j = 0; j < ck; j++) {
            tmp += cl;
          }
          i += 2;
        } else {
          tmp += String.valueOf(k.charAt(i));
        }
      }
      System.out.println(tmp);
    }
  }
}
