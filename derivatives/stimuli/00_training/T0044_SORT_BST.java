public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] num = new int[n];
    for (int i = 0; i < n; i++) {
      num[i] = sc.nextInt();
    }
    int temp;
    int count = 0;
    for (int i = 0; i < num.length; i++) {
      for (int j = num.length - 1; j > i; j--) {
        if (num[j] < num[j - 1]) {
          temp = num[j];
          num[j] = num[j - 1];
          num[j - 1] = temp;
          count++;
        }
      }
    }
    System.out.print(num[0]);
    for (int i = 1; i < num.length; i++) {
      System.out.print(" " + num[i]);
    }
    System.out.println();
    System.out.println(count);
  }
}
