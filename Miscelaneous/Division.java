/*
 * Write a function to perform integer division without using either the / or *
 * operators. Find a fast way to do it.
*/

public class Division {

  public static int divide(int a, int b) {
    if (a == 0 || Math.abs(a) < Math.abs(b)) {
      return 0;
    } 
    
    if (b == 0) {
      if (a > 0) {
        return Integer.MAX_VALUE;
      } else {
        return Integer.MIN_VALUE;
      } 
    }

    if (a == b) {
      return 1;
    }

    /* Gets the absolute value of both numbers and stores
     * a boolean that determines if the quotient is
     * positive or negative */
    boolean resIsNegative;

    if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
      resIsNegative = true;
    } else {
      resIsNegative = false;
    } 

    a = Math.abs(a);
    b = Math.abs(b);
    int res = 0;
    while ((a -= b) >= 0) {
      res++;
    }

    if (resIsNegative) {
      return -res;
    } else {
      return res;
    }
  }

  public static void test() {
    /* base case */
    System.out.println("In this method, 0/0 = 0: " + Division.divide(0,0));
    System.out.println("0: " + Division.divide(0,2));
    System.out.println("0: " + Division.divide(1,2));
    System.out.println("1: " + Division.divide(2,2));
    System.out.println("MAX: " + Division.divide(1,0));
    System.out.println("MIN: " + Division.divide(-1,0));
    /* positive integer */
    System.out.println("3: " + Division.divide(100,30));      
    System.out.println("5000: " + Division.divide(10000, 2));      
    System.out.println("3: " + Division.divide(-1022,-301));      
    /* negative integer */
    System.out.println("-3: " + Division.divide(-100,30));      
    System.out.println("-2: " + Division.divide(50,-25));      
    
  }

  public static void main(String[] args) {
    Division.test();
  }
}