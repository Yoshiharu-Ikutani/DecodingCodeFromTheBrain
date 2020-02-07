public class Main {
  void function1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] S = br.readLine().split(" ");
    int q = Integer.parseInt(br.readLine());
    String[] T = br.readLine().split(" ");
    int count = 0;
    boolean check;
    for (int i = 0; i < q; i++) {
      String searchWord = T[i];
      check = false;
      for (int j = 0; j < n; j++) {
        if (!check && searchWord.equals(S[j])) {
          count++;
          check = true;
        }
      }
    }
    System.out.println(count);
  }

  public static void main(String[] args) throws IOException {
    new Main().function1();
  }
}
