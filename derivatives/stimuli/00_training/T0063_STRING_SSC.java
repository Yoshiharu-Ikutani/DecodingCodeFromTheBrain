class Main {
  public static void main(String[] args) throws IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    int c = 0;
    String sw = "";
    for (int ii = 0;; ii++) {
      String line = br.readLine();
      if (ii == 0) {
        sw = line.toLowerCase();
        continue;
      }
      if (line.equals("END_OF_TEXT") || line == null || line.length() == 0) {
        break;
      }
      String[] ss = line.split(" ");
      for (int jj = 0; jj < ss.length; jj++) {
        if (sw.equals(ss[jj].toLowerCase())) {
          c++;
        }
      }
    }
    System.out.println(c);
  }
}
