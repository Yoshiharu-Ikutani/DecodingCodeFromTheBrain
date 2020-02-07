public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    Integer length = s.nextInt();
    Integer[] seq = new Integer[length];
    for (int i = 0; i < length; i++) {
      seq[i] = s.nextInt();
    }
    Integer count = 0;
    for (int i = 0; i < length; i++) {
      Integer mini = i;
      for (int j = i; j < length; j++) {
        if (seq[j] < seq[mini]) {
          mini = j;
        }
      }
      Integer bkp = seq[i];
      if (seq[i] != seq[mini]) {
        seq[i] = seq[mini];
        seq[mini] = bkp;
        count++;
      }
    }
    for (int i = 0; i < length; i++) {
      if (i == length - 1) {
        System.out.print(seq[i] + "\n");
      } else {
        System.out.print(seq[i] + " ");
      }
    }
    System.out.println(count);
  }
}
