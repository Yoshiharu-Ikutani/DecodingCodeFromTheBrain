public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<String> inputs = new ArrayList<String>();

    String target = sc.next();
    function1(sc, inputs);
    System.out.println(function2(target, inputs));
  }

  public static void function1(Scanner sc, ArrayList<String> list) {
    while (sc.hasNext()) {
      String input = sc.next();
      if (input.compareTo("END_OF_TEXT") == 0) {
        break;
      }
      list.add(input);
    }
  }

  public static int function2(String target, ArrayList<String> list) {
    int count = 0;
    for (int i = 0; i < list.size(); i++) {
      if (target.compareToIgnoreCase(list.get(i)) == 0) {
        count++;
      }
    }
    return count;
  }
}
