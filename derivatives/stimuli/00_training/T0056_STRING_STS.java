public class Main {
  public static void main(String[] args) {
    try {
      BufferedReader stdReader = new BufferedReader(new InputStreamReader(System.in));
      String line = null;
      line = stdReader.readLine();
      int times = Integer.parseInt(line);
      String[] st = new String[times];
      for (int i = 0; i < times; i++) {
        st[i] = stdReader.readLine();
      }
      Arrays.sort(st);
      System.out.println(st[0]);
    } catch (Exception e) {
      System.out.println(e);
      e.getStackTrace();
      System.exit(-1);
    }
  }
}
