class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n, tmp, count = 0;
    n = sc.nextInt();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt();
    }
    n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      tmp = sc.nextInt();
      if (Arrays.binarySearch(nums, tmp) >= 0) {
        count++;
      }
    }
    System.out.println(count);
  }
}
