class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    ArrayList<Integer> numList01 = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) {
      numList01.add(i, scanner.nextInt());
    }
    n = scanner.nextInt();
    ArrayList<Integer> numList02 = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) {
      numList02.add(i, scanner.nextInt());
    }
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (numList01.contains(numList02.get(i))) {
        count++;
      }
    }
    System.out.println(count);
    scanner.close();
  }
}
