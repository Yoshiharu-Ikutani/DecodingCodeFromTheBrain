class Main {
  Scanner sc = new Scanner(System.in);

  void function1() {
    int gundam = 0;
    int n = sc.nextInt();
    int[] N = new int[n];
    for (int i = 0; i < n; i++)
      N[i] = sc.nextInt();
    int q = sc.nextInt();
    for (int i = 0; i < q; i++) {
      int Q = sc.nextInt();
      int L = 0;
      int R = n - 1;
      while (N[L] <= Q && Q <= N[R]) {
        int cent = (L + R) / 2;
        if (N[cent] == Q) {
          gundam++;
          break;
        } else if (N[cent] > Q)
          R = cent - 1;
        else
          L = cent + 1;
      }
    }
    System.out.println(gundam);
  }

  public static void main(String[] args) {
    new Main().function1();
  }
}
