class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(in.readLine());
    String[] data = in.readLine().split(" ");
    int[] A = new int[n];
    for (int i = 0; i < n; i++) {
      A[i] = Integer.parseInt(data[i]);
    }
    System.out.print(A[0]);
    for (int k = 1; k < n; k++) {
      System.out.print(" " + A[k]);
    }
    System.out.println();
    for (int i = 1; i < n; i++) {
      int v = A[i];
      int j = i - 1;
      while (j >= 0 && A[j] > v) {
        A[j + 1] = A[j];
        j--;
      }
      A[j + 1] = v;
      System.out.print(A[0]);
      for (int k = 1; k < n; k++) {
        System.out.print(" " + A[k]);
      }
      System.out.println();
    }
  }
}
