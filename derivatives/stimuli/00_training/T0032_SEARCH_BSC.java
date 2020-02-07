public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] S = new int[n];
    for (int i = 0; i < n; i++) {
      S[i] = sc.nextInt();
    }
    int q = sc.nextInt();
    int[] T = new int[q];
    for (int i = 0; i < q; i++) {
      T[i] = sc.nextInt();
    }
    int low, mid, high, key, cnt = 0;
    for (int i = 0; i < q; i++) {
      low = 0;
      high = n - 1;
      key = T[i];
      while (low <= high) {
        mid = (low + high) / 2;
        if (S[mid] == key) {
          cnt++;
          break;
        } else if (S[mid] < key) {
          low = mid + 1;
        } else if (S[mid] > key) {
          high = mid - 1;
        }
      }
    }
    System.out.println(cnt);
  }
}
