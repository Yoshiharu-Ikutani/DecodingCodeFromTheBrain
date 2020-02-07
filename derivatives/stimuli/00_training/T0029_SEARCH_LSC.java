public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int arrayCnt = new Integer(s.nextLine()).intValue();
    String[] tmp = s.nextLine().split(" ");
    int[] targetArray = new int[arrayCnt];
    for (int i = 0; i < arrayCnt; i++) {
      targetArray[i] = new Integer(tmp[i]).intValue();
    }
    int cnt = new Integer(s.nextLine()).intValue();
    String[] aaa = s.nextLine().split(" ");
    int existCnt = 0;
    for (int i = 0; i < aaa.length; i++) {
      if (function1(targetArray, new Integer(aaa[i]).intValue())) {
        existCnt++;
      }
    }
    System.out.println(existCnt);
  }

  public static boolean function1(int[] targetArray, int aaa) {
    for (int i = 0; i < targetArray.length; i++) {
      if (targetArray[i] == aaa)
        return true;
    }
    return false;
  }
}
