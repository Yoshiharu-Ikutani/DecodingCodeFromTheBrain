public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }
    int min, tmp, cnt = 0;
    for (int i = 0; i < N - 1; i++) {
      min = i;
      for (int j = i + 1; j < N; j++) {
        if (A[min] > A[j]) {
          min = j;
        }
      }
      if (min != i) {
        tmp = A[min];
        A[min] = A[i];
        A[i] = tmp;
        cnt++;
      }
    }
    for (int i = 0; i < N; i++) {
      if (i == N - 1) {
        System.out.println(A[i]);
      } else {
        System.out.print(A[i] + " ");
      }
    }
    System.out.println(cnt);
  }
}
