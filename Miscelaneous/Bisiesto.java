import java.util.Scanner;


public class Bisiesto {
 
  public static boolean isBisiesto(int n) {
    
    return (n % 4 != 0) ? false : ((n % 100 != 0) ? true : ((n % 400 == 0) ? true : false)); 
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    for (int i = 0; i < n; i++){
      String res = isBisiesto(in.nextInt()) ? "S" : "N";
      System.out.println(res);
    }
    in.close();
  }   
}