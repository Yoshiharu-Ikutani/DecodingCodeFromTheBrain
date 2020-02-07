class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int AA1 = Integer.parseInt(br.readLine());
    String[] in = br.readLine().split("\\s+");
    int[] AA = new int[AA1];
    for (int i = 0; i < AA1; i++) {
      AA[i] = Integer.parseInt(in[i]);
    }
    int AA2 = Integer.parseInt(br.readLine());
    String[] in2 = br.readLine().split("\\s+");
    int[] AAA = new int[AA2];
    int ans = 0;
    for (int i = 0; i < AA2; i++) {
      AAA[i] = Integer.parseInt(in2[i]);
      for (int j = 0; j < AA1; j++) {
        if (AAA[i] == AA[j]) {
          ans++;
          break;
        }
      }
    }
    System.out.println(ans);
  }
}
