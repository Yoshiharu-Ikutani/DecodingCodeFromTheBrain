public class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    byte min, count = 0, arrayLength = Byte.parseByte(in.readLine());
    byte[] array = new byte[arrayLength];
    String[] strData = in.readLine().split(" ");
    for (int i = 0; i < arrayLength; i++) {
      array[i] = Byte.parseByte(strData[i]);
    }
    for (byte x = 0; x < arrayLength; x++) {
      min = x;
      for (byte y = (byte) (x + 1); y < arrayLength; y++) {
        if (array[min] > array[y]) {
          min = y;
        }
      }
      if (array[x] > array[min]) {
        byte temp = array[x];
        array[x] = array[min];
        array[min] = temp;
        count++;
      }
    }
    for (int j = 0; j < arrayLength; j++) {
      if (j == arrayLength - 1) {
        System.out.println(array[j]);
      } else {
        System.out.print(array[j] + " ");
      }
    }
    System.out.println(count);
  }
}
