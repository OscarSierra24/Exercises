//https://app.codesignal.com/interview-practice/task/RvDFbsNC3Xn7pnQfH
// Definition for singly-linked list:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
class AddTwoHugeNumbers {
  ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {

    ListNode<Integer> current;
    ListNode<Integer> prev;
    ListNode<Integer> next;
    ListNode<Integer> pointerA;
    ListNode<Integer> pointerB;
    ListNode<Integer> headBig; // head node of the biggest list
    ListNode<Integer> pointerBig; // pointer of the biggest list
    ListNode<Integer> pointerShort; // pointer of the shortest list

    int lengthA;
    int lengthB;
    int carry;
    int res;

    lengthA = 0;
    lengthB = 0;

    prev = null;
    current = a;
    next = current;

    while (current != null) {
      next = next.next;
      current.next = prev;
      prev = current;
      current = next;
      lengthA++;
    }
    pointerA = prev;

    prev = null;
    current = b;
    next = b;
    while (current != null) {
      next = next.next;
      current.next = prev;
      prev = current;
      current = next;
      lengthB++;
    }
    pointerB = prev;

    // choose were the result will be deposited
    if (lengthA >= lengthB) {
      pointerBig = pointerA;
      pointerShort = pointerB;
    } else {
      pointerBig = pointerB;
      pointerShort = pointerA;
    }
    headBig = pointerBig;

    res = 0;
    carry = 0;

    prev = pointerBig; // prev is used in case both ll have the same size and we need to add
    // an extra node to deposit the remain carry

    // iterate both ll and make the addition (store it in the biggest list to save
    // space)
    while (pointerShort != null) {
      res = (pointerBig.value + pointerShort.value) + carry;
      pointerBig.value = (res % 10000);
      carry = (res / 10000);

      prev = pointerBig;
      pointerBig = pointerBig.next;
      pointerShort = pointerShort.next;
    }
    // if we finished iterating the shortest list and there's still a carry
    while (carry != 0) {
      System.out.println(carry);
      if (pointerBig != null) {
        res = pointerBig.value + carry;
        pointerBig.value = (res % 10000);
        carry = (res / 10000);

      } else {
        pointerBig = prev;
        pointerBig.next = new ListNode<Integer>(carry);
        break;
      }
      prev = pointerBig;
      pointerBig = pointerBig.next;
    }

    // reverse the ll that stores the result (because it is inverted)
    current = headBig;
    prev = null;
    next = current;
    while (current != null) {
      next = next.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    // return the head of the ll that contains the result
    return prev;
  }
}