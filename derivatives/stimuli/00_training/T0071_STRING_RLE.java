class Main {
  public static void main(String[] args) {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    try {
      String st;
      while ((st = sc.readLine()) != null) {
        char[] c = st.toCharArray();
        int i = 0;
        while (i < c.length) {
          if (c[i] == '@') {
            int n = c[i + 1] - '0';
            for (int j = 1; j < n; j++)
              System.out.print(c[i + 2]);
            i += 2;
          } else {
            System.out.print(c[i]);
            i++;
          }
        }
        System.out.println();
      }
    } catch (Exception e) {
      System.out.println("Error");
    }
  }
}
