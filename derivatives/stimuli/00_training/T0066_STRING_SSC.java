class Main {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String w, t;
    int cnt = 0;

    w = scan.next();

    while (true) {
      t = scan.next();

      if (t.equals("END_OF_TEXT")) {
        break;
      }
      if (w.equalsIgnoreCase(t)) {
        cnt++;
      }
    }
    System.out.println(cnt);
  }
}
