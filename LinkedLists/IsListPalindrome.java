class IsListPalindrome {
  // O(n) time O(1) additional space solution
  // Definition for singly-linked list:
  // class ListNode<T> {
  // ListNode(T x) {
  // value = x;
  // }
  // T value;
  // ListNode<T> next;
  // }
  //
  boolean isListPalindrome(ListNode<Integer> l) {
    int length;
    int midPoint;
    ListNode<Integer> current;
    ListNode<Integer> prev;
    ListNode<Integer> next;
    ListNode<Integer> rPointer;
    ListNode<Integer> lPointer;

    // get length of ll
    length = 0;
    current = l;
    while (current != null) {
      length++;
      current = current.next;
    }
    midPoint = length / 2;

    // iterate until lPointer = midpoint
    lPointer = l;
    for (int i = 0; i < midPoint; i++) {
      lPointer = lPointer.next;
    }

    // flip pointers from mid to last element
    current = lPointer;
    prev = null;
    next = current;
    while (current != null) {
      next = next.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    // rpointer is the first element whereas lpointer is the last element in the
    // list we received
    // r : right
    // l : left
    rPointer = l;
    lPointer = prev;
    for (int i = 0; i < midPoint; i++) {
      if (!rPointer.value.equals(lPointer.value)) {
        return false;
      }
      rPointer = rPointer.next;
      lPointer = lPointer.next;
    }
    return true;
  }

}