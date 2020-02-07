public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] numbers = new int[n];
    for (int i = 0; i < n; i++) {
      numbers[i] = Integer.parseInt(br.readLine());;
    }
    int ans = 0;
    for (int i = 0; i < numbers.length; i++) {
      boolean flag = true;
      int j = 2;
      while (j <= Math.sqrt(numbers[i])) {
        if (numbers[i] % j == 0) {
          flag = false;
          break;
        }
        j++;
      }
      if (flag) {
        ans++;
      }
    }
    System.out.println(ans);
  }
}
