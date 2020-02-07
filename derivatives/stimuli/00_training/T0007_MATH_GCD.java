public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int x = Integer.parseInt(scanner.next());
    int y = Integer.parseInt(scanner.next());
    if (x == y) {
      System.out.println(x);
      return;
    }
    if (x < y) {
      int tmp = x;
      x = y;
      y = tmp;
    }
    while (true) {
      int z = x % y;
      if (x % z == 0 && y % z == 0) {
        System.out.println(z);
        break;
      }
      x = y;
      y = z;
    }
  }
}
