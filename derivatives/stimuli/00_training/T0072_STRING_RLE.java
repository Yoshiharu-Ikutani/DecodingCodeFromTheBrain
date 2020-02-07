class Main {

  public static void main(String[] args) {

    final Scanner stdin = new Scanner(System.in);

    while (stdin.hasNextLine()) {

      final String input = stdin.nextLine();
      final StringBuilder sb = new StringBuilder();
      for (int i = 0; i < input.length(); i++) {
        if (input.charAt(i) != '@') {
          sb.append(input.charAt(i));
        } else {
          final int no = input.charAt(i + 1) - '0';
          final char ch = input.charAt(i + 2);
          for (int j = 0; j < no; j++) {
            sb.append(ch);
          }
          i += 2;
        }
      }
      System.out.println(sb.toString());
    }
  }
}
