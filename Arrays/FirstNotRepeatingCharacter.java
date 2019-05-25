class FirstNotRepeatingCharacter {
  char firstNotRepeatingCharacter(String s) {
    int[] asciiRep = new int[26];
    int asciiVal;
    final int initValue = 97;

    char[] cString = s.toCharArray();
    LinkedList<Integer> orderOfArrival = new LinkedList<>();

    for (int i = 0; i < cString.length; i++) {
      asciiVal = (int) (cString[i]) - initValue;
      if (asciiRep[asciiVal] == 0) {
        asciiRep[asciiVal] = 1;
        orderOfArrival.add(asciiVal);

      } else if (asciiRep[asciiVal] == 1) {
        asciiRep[asciiVal] = 2;
      }
    }

    for (int i = 0; i < orderOfArrival.size(); i++) {
      if (asciiRep[orderOfArrival.get(i)] == 1) {
        return (char) (orderOfArrival.get(i) + initValue);
      }
    }
    return '_';
  }
}