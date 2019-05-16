class ArmstrongNumber {
  // Given a number x, determine whether the given number is Armstrong number or not.
  //A positive integer of n digits is called an Armstrong number of order n (order is number of digits) if.
  //abcd... = pow(a,n) + pow(b,n) + pow(c,n) + pow(d,n) + .... 

  public static int getDigitLength(int n) {
    int counter = 0;
    
    while (n > 0) {
      n = n / 10;
      counter++;
    }
    return counter;
  }

  public static int power(int number, int power) {
    int res = number;
    for (int i = 0; i < power - 1; i++) { 
      res *= number;
    }
    return res;
  }

  public static boolean isArmstrong(int number) {
    if (number < 0) {
      return false;
    }

    int multResult = 0;
    int power = getDigitLength(number);
    int d;
    int numberCopy = number;
    while (numberCopy > 0) {
      d = numberCopy % 10;
      multResult += power(d, power);
      numberCopy = numberCopy / 10;
    }
    
    return (multResult == number) ? true : false;
  }

  public static void main(String[] args) {
    for (int i = 0; i < 1000; i++) {
      if (isArmstrong(i)) {
        System.out.println(i);
      }
    }
  }
}