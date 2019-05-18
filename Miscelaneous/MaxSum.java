import java.util.Scanner;

class MaxSum {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }

    in.close();
    
    System.out.println(getMaxSum(arr));
    
  }

  public static int getMaxSum(int[] arr) {
    int currentMax = 0;
    int max = 0;

    for (int i = 0; i < arr.length; i++) {
      if (currentMax + arr[i] < 0) {
        currentMax = 0;
        continue;
      }

      currentMax += arr[i];
      
      
      if (max < currentMax) {
        max = currentMax;
      }
      
    }

    return max;
  }
}