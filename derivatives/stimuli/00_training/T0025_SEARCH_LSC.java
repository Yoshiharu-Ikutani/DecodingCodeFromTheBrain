public class Main {
  public static void main(String[] args) {
    new Main().function1();
  }

  private void function1() {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] num = new int[n];
    for (int i = 0; i < n; i++) {
      num[i] = scanner.nextInt();
    }
    int m = scanner.nextInt();
    int count = 0;
    while (m-- > 0) {
      int a = scanner.nextInt();
      for (int i = 0; i < n; i++) {
        if (a == num[i]) {
          count++;
          break;
        }
      }
    }
    System.out.println(count);
  }
}
