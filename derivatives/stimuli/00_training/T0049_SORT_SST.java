public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int N, cnt = 0;
    int[] A = new int[100];
    int i, j, temp, min;
    N = sc.nextInt();
    for (i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }
    for (i = 0; i < N; i++) {
      min = i;
      for (j = i; j < N; j++) {
        if (A[j] < A[min]) {
          min = j;
        }
      }
      if (i != min) {
        temp = A[i];
        A[i] = A[min];
        A[min] = temp;
        cnt++;
      }
    }
    for (i = 0; i < N - 1; i++) {
      System.out.print(A[i] + " ");
    }
    System.out.println(A[i]);
    System.out.println(cnt);
  }
}
