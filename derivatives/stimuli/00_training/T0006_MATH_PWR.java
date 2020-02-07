public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nums = br.readLine().trim().split(" ");
    BigInteger n = new BigInteger(nums[0]);
    BigInteger m = new BigInteger(nums[1]);
    BigInteger mod = new BigInteger("1000000007");
    System.out.println(n.modPow(m, mod));
    if (br != null) {
      br.close();
      br = null;
    }
  }
}
