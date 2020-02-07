class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Deque<Integer> stack = new ArrayDeque<Integer>();
    String[] str = (br.readLine()).split(" ");
    int count = 0;
    for (int i = 0; i < n; i++) {
      stack.addLast(Integer.parseInt(str[i]));
    }
    int q = Integer.parseInt(br.readLine());
    String[] st = (br.readLine()).split(" ");
    int[] num = new int[q];
    for (int i = 0; i < q; i++) {
      num[i] = Integer.parseInt(st[i]);
    }
    Arrays.sort(num);
    int a;
    try {
      for (int i = 0; i < q; i++) {
        while ((a = stack.pollFirst()) < num[i]);
        if (num[i] == a) {
          count++;
        } else {
          stack.addFirst(a);
          continue;
        }
      }
    } catch (NullPointerException e) {
    }
    System.out.println(count);
  }
}
