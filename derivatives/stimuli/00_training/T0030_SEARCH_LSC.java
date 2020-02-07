class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    int n1 = Integer.parseInt(br.readLine());
    int[] a1 = new int[n1];
    String[] s1 = br.readLine().split(" ");
    for (int i = 0; i < n1; i++)
      a1[i] = Integer.parseInt(s1[i]);
    int n2 = Integer.parseInt(br.readLine());
    int[] a2 = new int[n2];
    String[] s2 = br.readLine().split(" ");
    for (int i = 0; i < n2; i++)
      a2[i] = Integer.parseInt(s2[i]);
    int ans = 0;
    for (int i : a2)
      for (int j : a1) {
        if (j == i) {
          ans++;
          break;
        }
      }
    System.out.println(ans);
  }
}
