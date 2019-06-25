import java.util.ArrayList;
import java.util.List;

class BiggestSquare {
  public static void main(String[] args) {
    int[][] arr2 = {{1,0,0,0}, {1,1,0,0}, {1,1,1,1}, {0,1,1,1}, {0,1,1,1}};
    List<int[]> list = biggestSquare(arr2);
    
    for (int i = 0; i < list.size(); i++) {
      System.out.println("coord: " + list.get(i)[0] + "i " + list.get(i)[1] + "j");
    }
  }

  private static boolean squareCanGrow(int[][] arr, int i, int j, int size) {
    /** Checks if the current square can grow by visiting the next possible row 
     *  and the next possible column and seeing if there are positions with 0 as value
     *  if there's a 0, then the square cannot grow more  
     */
    final int nextColPos = j + size;
    final int nextRowPos = i + size;
    
    if (nextRowPos > arr.length - 1 || nextColPos > arr[0].length - 1) {
      return false;
    }
    for (int index = j; index <= nextColPos; index++) {
      if (arr[nextRowPos][index] == 0) {
        return false;
      }
    }
    for (int index = i; index <= nextRowPos; index++) {
      if (arr[index][nextColPos] == 0) {
        return false;
      }
    }
    return true;
  }

  public static List<int[]> biggestSquare(int[][] arr) {
    int biggestSquareSize = 1;
    int[] lUCoord = {0,0}; //left upper
    int[] rUCoord = {0,0}; //right upper
    int[] lLCoord = {0,0}; //left lower
    int[] rLCoord = {0,0}; //right lower

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        if (arr[i][j] != 1) continue;
        
        int size = 1;
        while (squareCanGrow(arr, i, j, size)) {
          size++;
        }

        if (size > biggestSquareSize) {
          biggestSquareSize = size;
          size--;
          lUCoord = new int[] {i, j};
          rUCoord = new int[] {i, j + size};
          lLCoord = new int[] {i + size, j};
          rLCoord = new int[] {i + size, j + size};
        }
      }
    }

    List<int[]> list = new ArrayList<>();
    list.add(lUCoord);
    list.add(rUCoord);
    list.add(lLCoord);
    list.add(rLCoord);
    return list;
  }
}