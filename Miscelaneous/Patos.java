import java.util.Arrays;
import java.util.Scanner;

class Patos {


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    boolean[] boolArr = new boolean[101];
    Arrays.fill(boolArr, Boolean.FALSE);
    
    int firstValue = sc.nextInt();
    int min = firstValue;
    int max = firstValue;
    boolArr[firstValue] = true;
    int current;
    for (int i = 0; i < n - 1; i++) {
      current = sc.nextInt();
      if (current < min) {
        min = current;
      }
      if (current > max) {
        max = current;
      }
      boolArr[current] = true;
    }
    
    int res = 0;
    for (int i = min; i < max; i++) {
      if (!boolArr[i]) {
        res++;
      }
    }

    System.out.println(res);
    sc.close();
  }
}