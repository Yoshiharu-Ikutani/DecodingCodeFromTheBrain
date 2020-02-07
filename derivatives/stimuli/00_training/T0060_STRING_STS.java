public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int x = scan.nextInt();
    ArrayList<String> list = new ArrayList<String>();
    for (int i = 0; i < x; i++) {
      list.add(scan.next());
    }
    Collections.sort(list);
    System.out.println(list.get(0));
  }

}
