// https://app.codesignal.com/interview-practice/task/5vcioHMkhGqkaQQYt

class RearrangeLastNNodes {
  // Definition for singly-linked list:
  // class ListNode<T> {
  // ListNode(T x) {
  // value = x;
  // }
  // T value;
  // ListNode<T> next;
  // }
  //
  ListNode<Integer> rearrangeLastN(ListNode<Integer> l, int n) {
    if (n == 0 || l == null) return l;

    ListNode<Integer> slow; // used to iterate the list
    ListNode<Integer> fast; // the node that is n positions ahead of current
    ListNode<Integer> prev;

    prev = null;
    slow = l;
    fast = l;

    for (int i = 1; i < n; i++) {
      fast = fast.next;
      if (fast == null) return l; // if list length is less than n, then there's nothing to rearrange
    }
    if (fast.next == null) return l; // if list length is n, then there's nothing to rearrange

    // iterate until the node that is n positions ahead faces null
    // curent will be n nodes away from the end
    while (fast.next != null) {
      fast = fast.next;
      prev = slow;
      slow = slow.next;
    }
    // n+1 nodes away from the end is going to be the end of the ll, and it is
    // stored on prev
    // therefore, prev next value goes to null
    prev.next = null;

    // the tail now points towards the beggining of l
    fast.next = l;

    return slow;
  }

}