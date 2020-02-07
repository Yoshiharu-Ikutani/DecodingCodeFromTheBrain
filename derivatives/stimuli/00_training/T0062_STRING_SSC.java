public class Main {
  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    try {
      int count = 0;
      String st = br.readLine();
      char[] stc = st.toCharArray();
      while (true) {
        String[] ln = br.readLine().split(" "); // ln[0] -> this, ln[1] -> is, e.g.
        if (ln[0].equals("END_OF_TEXT"))
          break;
        for (int i = 0; i < ln.length; i++) {
          char[] lnc = ln[i].toCharArray(); // lnc[0]->t, lnc[1]->h, lnc[2]->i, e.g.
          for (int j = 0; j < stc.length && j < lnc.length; j++) {
            if (Character.toLowerCase(stc[j]) != Character.toLowerCase(lnc[j])) {
              break;
            }
            if (j == stc.length - 1 && j == lnc.length - 1) { // if words have same length
              count++;
            }
          }
        }
      }
      System.out.println(count);
    } catch (Exception e) {
    }
  }
}
