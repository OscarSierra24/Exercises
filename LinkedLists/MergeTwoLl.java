class MergeTwoLl {
  // Definition for singly-linked list:
  // class ListNode<T> {
  // ListNode(T x) {
  // value = x;
  // }
  // T value;
  // ListNode<T> next;
  // }
  //
  ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
    if (l1 == null) return l2;
    else if (l2 == null) return l1;

    ListNode<Integer> res, head;

    if (l1.value > l2.value) {
      res = l2;
      l2 = l2.next;
    } else {
      res = l1;
      l1 = l1.next;
    }
    head = res;

    while (l1 != null && l2 != null) {
      if (l1.value > l2.value) {
        res.next = l2;
        l2 = l2.next;
      } else {
        res.next = l1;
        l1 = l1.next;
      }
      res = res.next;
    }
    res.next = l1 != null ? l1 : l2;

    return head;
  }

}