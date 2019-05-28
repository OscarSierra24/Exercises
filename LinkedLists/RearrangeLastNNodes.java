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
    if (n == 0) return l;
    if (l == null) return null;

    ListNode<Integer> head; // stores the new head of the linked list
    ListNode<Integer> current; // used to iterate the list
    ListNode<Integer> guideNode; // the node that is n positions ahead of current
    ListNode<Integer> prev;

    prev = null;
    current = l;
    guideNode = l;

    for (int i = 1; i < n; i++) {
      guideNode = guideNode.next;
      if (guideNode == null) return l; // if list length is less than n, then there's nothing to rearrange
    }
    if (guideNode.next == null) return l; // if list length is n, then there's nothing to rearrange

    // iterate until the node that is n positions ahead faces null
    // curent will be n nodes away from the end
    while (guideNode.next != null) {
      guideNode = guideNode.next;
      prev = current;
      current = current.next;
    }
    // n+1 nodes away from the end is going to be the end of the ll, and it is
    // stored on prev
    // therefore, prev next value goes to null
    prev.next = null;
    // head is now at n nodes away from the end
    head = current;

    // traverse till the end
    while (current.next != null) {
      current = current.next;
    }

    // the tail now points towards the beggining of l
    current.next = l;

    return head;
  }

}