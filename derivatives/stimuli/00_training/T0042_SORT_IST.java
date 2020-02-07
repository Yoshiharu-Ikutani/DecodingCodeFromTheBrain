public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = scan.nextInt();
    }
    function1(A, N);
  }

  public static void function1(int[] A, int N) {
    String output = Arrays.toString(A).replaceAll(",", "");
    System.out.println(output.substring(1, output.length() - 1));
    for (int i = 1; i < N; i++) {
      int v = A[i];
      int j = i - 1;
      while (j >= 0 && A[j] > v) {
        A[j + 1] = A[j];
        j--;
        A[j + 1] = v;
      }
      output = Arrays.toString(A).replaceAll(",", "");
      System.out.println(output.substring(1, output.length() - 1));
    }
  }
}
