public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    new Main().function1();
  }

  private void function1() throws IOException {
    st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int x, y;
    if (a > b) {
      x = a;
      y = b;
    } else {
      x = b;
      y = a;
    }
    while (y > 0) {
      int temp = x;
      x = y;
      y = temp % y;
    }
    System.out.println(x);
  }
}
