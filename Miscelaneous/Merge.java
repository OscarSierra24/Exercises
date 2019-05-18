import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Merge {
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    String s1 = sc.next();
    String s2 = sc.next();
    String s3 = sc.next();
    sc.close();
    System.out.println((isMerge(s1, s2, s3)) ? "VALID MERGE" : "INVALID MERGE"); 

  }

  public static boolean isMerge(String s1, String s2, String s3) {
    int indexS1 = 0;
    int indexS2 = 0;
    int s1Length = s1.length();
    int s2Length = s2.length();
    Set<Integer> savedLetters = new HashSet<>();

    for (int i = 0; i < s3.length(); i++) {
      
      if (indexS1 < s1Length && indexS2 < s2Length && s3.charAt(i) == s1.charAt(indexS1) && s3.charAt(i) == s2.charAt(indexS2)) {
        savedLetters.add((int) s1.charAt(indexS1));
        indexS1++;
        indexS2++;
        continue;
      }



      if (indexS1 < s1Length && s3.charAt(i) == s1.charAt(indexS1)) {
        indexS1++;
      } else if (indexS2 < s2Length && s3.charAt(i) == s2.charAt(indexS2)) {
        indexS2++;
      } else if (savedLetters.contains((int) s3.charAt(i))) {
        savedLetters.remove((int) s3.charAt(i));
      } else {
        return false;
      }
    }
    if (indexS1 == s1.length() && indexS2 == s2.length()) {
      return true;   
    }    
    return false;
  }

  
  /*
  public static boolean isMerge(String s1, String s2, String s3) {
    int[] memory = new int[26];// a: 97, z: 122 (ASCII)
    int s1Length = s1.length();
    int s2Length = s2.length();
    int s3Length = s3.length();
    if (s1Length + s2Length != s3Length) {
      return false;
    }

    for (int i = 0; i < s1Length; i++) {
      memory[s1.charAt(i) - 97]++;
    }

    for (int i = 0; i < s2Length; i++) {
      memory[s2.charAt(i) - 97]++;
    }

    for (int i = 0; i < s3Length; i++) {
      memory[s3.charAt(i) - 97]--;
    }

    for (int i = 0; i < memory.length; i++) {
      if (memory[i] != 0) {
        return false;
      } 
    }

    return true;
  }
  */
}