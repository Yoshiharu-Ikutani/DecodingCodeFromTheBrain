class Main {
  static final PrintWriter out = new PrintWriter(System.out);

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = "";
    while ((line = br.readLine()) != null && !line.isEmpty()) {
      int ans = 0;
      int n = Integer.parseInt(line);
      ArrayList<Integer> array = new ArrayList<Integer>();
      StringTokenizer st1 = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        int a = Integer.parseInt(st1.nextToken());
        array.add(a);
      }
      int m = Integer.parseInt(br.readLine());
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      for (int i = 0; i < m; i++) {
        int b = Integer.parseInt(st2.nextToken());
        if (array.indexOf(b) >= 0)
          ans++;
      }
      out.println(ans);
      out.flush();
    }
  }
}
