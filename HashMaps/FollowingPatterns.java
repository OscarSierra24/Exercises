//https://app.codesignal.com/interview-practice/task/3PcnSKuRkqzp8F6BN/solutions

class FollowingPatterns {
  boolean areFollowingPatterns(String[] strings, String[] patterns) {
    HashMap<String, String> map = new HashMap<>();
    Set<String> usedPatterns = new HashSet<>();

    for (int i = 0; i < strings.length; i++) {
      if (map.containsKey(strings[i])) {
        // if string is already in map and the patterns do not match return false
        if (!map.get(strings[i]).equals(patterns[i])) {
          return false;
        }
      } else {
        // if the patter has already been used by another string return false
        if (usedPatterns.contains(patterns[i])) {
          return false;
        }
        usedPatterns.add(patterns[i]);
        map.put(strings[i], patterns[i]);
      }
    }

    return true;
  }

}