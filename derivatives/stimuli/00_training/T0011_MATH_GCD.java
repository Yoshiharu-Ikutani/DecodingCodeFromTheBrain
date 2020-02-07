public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n1 = sc.nextInt();
    int n2 = sc.nextInt();
    function3(function1(n1, n2));
  }

  public static int function1(int a, int b) {
    if (a % b == 0)
      return b;
    else
      return function1(b, a % b);
  }

  public static void function2(int[] ary) {
    for (int i = 0; i < ary.length - 1; i++) {
      System.out.print(ary[i] + " ");
    }
    function3(ary[ary.length - 1]);
  }

  public static void function3(String n) {
    System.out.println(n);
  }

  public static void function3(int n) {
    System.out.println(n);
  }
}
