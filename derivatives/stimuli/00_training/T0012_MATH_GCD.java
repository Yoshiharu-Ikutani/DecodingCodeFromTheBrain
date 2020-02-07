public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] t = br.readLine().split(" ");
    int a = Integer.parseInt(t[0]);
    int b = Integer.parseInt(t[1]);
    System.out.println(function1(a, b));
  }

  public static int function1(int x, int y) {
    int r;
    if (x < y) {
      int temp;
      temp = x;
      x = y;
      y = temp;
    }
    while (y > 0) {
      r = x % y;
      x = y;
      y = r;
    }
    return x;
  }
}
