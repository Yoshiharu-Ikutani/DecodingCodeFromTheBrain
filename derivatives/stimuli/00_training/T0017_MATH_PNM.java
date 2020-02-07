public class Main {
  public static void main(String[] args) {
    try {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      String count = new String(in.readLine());
      int lineCount = Integer.parseInt(count);
      int pFlag = 0;
      int result = 0;
      for (int i = 0; i < lineCount; i++) {
        String num = new String(in.readLine());
        int iNum = Integer.parseInt(num);
        pFlag = 0;
        for (int j = 2; j <= Math.sqrt(iNum); j++) {
          if (iNum % j == 0) {
            pFlag = 1;
            break;
          }
        }
        if (pFlag == 0) {
          result++;
        }
      }
      System.out.println(result);
    } catch (IOException e) {
    }
  }
}
