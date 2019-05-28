//https://app.codesignal.com/interview-practice/task/xrFgR63cw7Nch4vXo
class GroupingDishes {
  String[][] groupingDishes(String[][] dishes) {
    HashMap<String, ArrayList<String>> map = new HashMap<>();

    for (int i = 0; i < dishes.length; i++) {
      for (int j = dishes[i].length - 1; j > 0; j--) {
        map.putIfAbsent(dishes[i][j], new ArrayList<String>());
        map.get(dishes[i][j]).add(dishes[i][0]);
      }
    }

    List<String> sortedKeys = new ArrayList<String>(map.size());
    sortedKeys.addAll(map.keySet());
    Collections.sort(sortedKeys);

    ArrayList<String> current = new ArrayList<>();
    ArrayList<String[]> result = new ArrayList<>();
    String[] tmp;
    for (String key : sortedKeys) {

      Collections.sort(map.get(key));
      current = map.get(key);

      if (current.size() < 2) continue;

      current.add(0, key);
      tmp = current.toArray(new String[current.size()]);
      result.add(tmp);
    }

    return result.toArray(new String[result.size()][]);
  }
}