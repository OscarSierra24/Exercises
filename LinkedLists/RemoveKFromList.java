//https://app.codesignal.com/interview-practice/task/gX7NXPBrYThXZuanm
class RemoveKFromList {
  // Definition for singly-linked list:
  // class ListNode<T> {
  // ListNode(T x) {
  // value = x;
  // }
  // T value;
  // ListNode<T> next;
  // }
  //
  ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
    ListNode<Integer> current;
    ListNode<Integer> prev;
    ListNode<Integer> firstNode;

    current = l;
    while (current != null && current.value == k) {
      current = current.next;
    }
    firstNode = current;
    prev = current;

    while (current != null) {
      if (current.value == k) {
        prev.next = current.next;
        current = prev.next;
      } else {
        prev = current;
        current = current.next;
      }
    }
    return firstNode;
  }
}