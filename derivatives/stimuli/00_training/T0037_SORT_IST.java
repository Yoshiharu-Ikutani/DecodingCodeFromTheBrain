public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = Integer.parseInt(scan.nextLine());
    String[] inputs = scan.nextLine().split(" ");
    int[] cards = new int[n];
    for (int i = 0; i < n; i++) {
      cards[i] = Integer.parseInt(inputs[i]);
    }
    for (int i = 1; i < n; i++) {
      function1(cards);
      int key = cards[i];
      int j = i - 1;
      while (j >= 0 && cards[j] > key) {
        cards[j + 1] = cards[j];
        j--;
      }
      cards[j + 1] = key;
    }
    function1(cards);
  }

  static void function1(int[] a) {
    for (int i = 0; i < a.length - 1; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println(a[a.length - 1]);
  }
}
