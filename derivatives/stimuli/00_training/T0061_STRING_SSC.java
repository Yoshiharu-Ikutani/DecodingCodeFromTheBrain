public class Main {
  static char[] a = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
      'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
  static char[] b = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
      'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
  static char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    int counter = 0;
    String W = stdIn.next();
    W = W.toLowerCase();
    while (stdIn.hasNext()) {
      String tmp = stdIn.next();
      tmp = tmp.toLowerCase();
      if (W.equals(tmp)) {
        counter++;
      }
    }
    System.out.println(counter);
  }

}
