public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int index = scan.nextInt();
    int[] arr = new int[index];
    for (int i = 0; i < index; i++) {
      arr[i] = scan.nextInt();
    }
    for (int i = 0; i < index; i++) {
      int key = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;
      for (int k = 0; k < index; k++) {
        System.out.print(arr[k]);
        if (k != index - 1)
          System.out.print(" ");
      }
      System.out.print("\n");
    }
  }
}
