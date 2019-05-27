class ReverseNodesInKG {
  // Definition for singly-linked list:
  // class ListNode<T> {
  // ListNode(T x) {
  // value = x;
  // }
  // T value;
  // ListNode<T> next;
  // }
  //
  ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k) {
    if (k == 1) return l;

    ListNode<Integer> guideNode;
    ListNode<Integer> current; // current pointer (used to reverse the ll)
    ListNode<Integer> next; // next (used to reverse the ll)
    ListNode<Integer> prev; // prev (used to reverse the ll)
    ListNode<Integer> lastKNode; // lastKNode (used to link previous K nodes with next K nodes)
    ListNode<Integer> head; // the new head of the ll

    guideNode = l;

    prev = null;
    current = l;
    next = l;
    lastKNode = null;
    head = null;

    boolean isReversable = true;
    while (guideNode != null) {
      for (int i = 1; i < k; i++) {
        guideNode = guideNode.next;
        if (guideNode == null) {
          // when guideNode finished travelling the ll
          isReversable = false;
          break;
        }
      }
      if (head == null) {
        head = guideNode;
      }
      if (isReversable) {
        if (lastKNode != null) {
          lastKNode.next = guideNode;
        }
        guideNode = guideNode.next; // make 1 jump to get to the start of the next k nodes
        lastKNode = current;
        prev = null;

        for (int i = 0; i < k; i++) {
          next = next.next;
          current.next = prev;
          prev = current;
          current = next;
        }

      } else {
        lastKNode.next = current;
      }
    }
    return head;
  }
}