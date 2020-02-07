public class Main {
  public static void main(String[] args) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    String min = "No Data";

    Pattern pt = Pattern.compile("^[a-z]*$");
    Matcher m;
    boolean f = false;
    try {
      while (null != (line = reader.readLine())) {
        if (pt.matcher(line).find()) {
          if (!f || min.compareTo(line) > 0) {
            min = line;
            f = true;
          }
        }
      }
      System.out.println(min);
    } catch (IOException e) {
      System.out.println(e);
    }
  }
}
