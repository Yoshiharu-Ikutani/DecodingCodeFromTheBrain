public class Main {
  public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> listS = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int q = Integer.parseInt(br.readLine());
        List<Integer> listT = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int count = 0;
        for (int i = 0; i < q; i++) {
            int t = listT.get(i);
            for (int j = 0; j < n; j++) {
                if (listS.get(j) == t) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
