public class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    byte arrayLength = Byte.parseByte(in.readLine());
    byte[] array = new byte[arrayLength];
    short count = 0;
    String[] strData = in.readLine().split(" ");
    for (byte i = 0; i < arrayLength; i++) {
      array[i] = Byte.parseByte(strData[i]);
    }
    for (int x = 0; x < arrayLength; x++) {
      for (byte y = (byte) (arrayLength - 1); y > x; y--) {
        if (array[y] < array[y - 1]) {
          byte temp = array[y];
          array[y] = array[y - 1];
          array[y - 1] = temp;
          count++;
        }
      }
    }
    for (int z = 0; z < arrayLength; z++) {
      if (z == arrayLength - 1) {
        System.out.println(array[z]);
      } else {
        System.out.print(array[z] + " ");
      }
    }
    System.out.println(count);
  }
}
