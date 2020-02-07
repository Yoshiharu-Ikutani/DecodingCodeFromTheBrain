class Main {
  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      String s, first = "";
      for (int i = 0; i < n; i++) {
        s = br.readLine();
        if (i == 0 || function1(first, s))
          first = s;
      }
      System.out.println(first);
    } catch (IOException e) {
      System.out.println(e);
    }
  }

  public static boolean function1(String f, String s) {
    int i = 0;
    while (i < f.length()) {
      if (f.charAt(i) < s.charAt(i))
        return false;
      else if (f.charAt(i) > s.charAt(i))
        return true;
      i++;
      if (i >= s.length())
        return true;
    }
    return false;
  }
}
