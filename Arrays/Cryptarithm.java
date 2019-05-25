class Cryptarithm {
  boolean isCryptSolution(String[] crypt, char[][] solution) {
    Map<Character, Character> dict = new HashMap<>();

    for (int i = 0; i < solution.length; i++) {
      dict.put(solution[i][0], solution[i][1]);
    }

    boolean containsALeadingZero = false;

    containsALeadingZero = (crypt[0].length() > 1 && dict.get((char) crypt[0].charAt(0)) == '0') ? true
        : containsALeadingZero;
    containsALeadingZero = (crypt[1].length() > 1 && dict.get((char) crypt[1].charAt(0)) == '0') ? true
        : containsALeadingZero;
    containsALeadingZero = (crypt[2].length() > 1 && dict.get((char) crypt[2].charAt(0)) == '0') ? true
        : containsALeadingZero;

    if (containsALeadingZero) {
      return false;
    }

    StringBuilder[] resWord = new StringBuilder[crypt.length];
    BigInteger[] intResWord = new BigInteger[crypt.length];

    for (int i = 0; i < resWord.length; i++) {
      resWord[i] = new StringBuilder();
    }

    for (int i = 0; i < crypt.length; i++) {
      for (int j = 0; j < crypt[i].length(); j++) {
        resWord[i].append(dict.get(crypt[i].charAt(j)));
      }
    }

    for (int i = 0; i < resWord.length; i++) {
      intResWord[i] = new BigInteger(resWord[i].toString());
    }

    if (intResWord[0].add(intResWord[1]).compareTo(intResWord[2]) == 0) {
      return true;
    } else {
      return false;
    }
  }

}