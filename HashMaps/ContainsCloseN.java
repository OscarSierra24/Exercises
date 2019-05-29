//https://app.codesignal.com/interview-practice/task/njfXsvjRthFKmMwLC/solutions

class ContainsCloseN {
  boolean containsCloseNums(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        if (map.get(nums[i]) + k >= i) {
          return true;
        } else {
          map.put(nums[i], i);
        }
      } else {
        map.put(nums[i], i);
      }
    }

    return false;
  }
}