public class Main {
  public static int x;
  public static int y;
  public static int z;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    x = sc.nextInt();
    y = sc.nextInt();
    if (x > y) {
      function1(x, y);
    } else {
      function1(y, x);
    }
    System.out.println(z);
  }

  public static void function1(int big, int small) {
    z = big % small;
    if (z == 0) {
      z = small;
    } else {
      function1(small, z);
    }
  }
}
