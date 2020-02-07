class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String W, str;
    int cnt = 0;

    W = in.next();

    while (true) {
      str = in.next();

      if (str.equals("END_OF_TEXT"))
        break;

      if (str.equalsIgnoreCase(W))
        ++cnt;
    }
    System.out.println(cnt);
  }
}
