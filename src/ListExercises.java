public class ListExercises {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode sum = new ListNode();
        ListNode start = sum;
        int rest =0;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                sum.val = l1.val + l2.val + rest;
                rest=0;
                if (sum.val >= 10) {
                    rest = 1;
                    sum.val = sum.val - 10;
                }
                if (l1.next == null && l2.next == null) {
                    if (rest!=0) {
                        sum.next = new ListNode(rest);
                    }
                    return start;
                }
                l1 = l1.next;
                l2 = l2.next;
                sum.next = new ListNode();
                sum = sum.next;
            }
            else if (l1 == null) {
                sum.val = l2.val + rest;
                rest=0;
                if (sum.val >= 10) {
                    rest = 1;
                    sum.val = sum.val - 10;
                }
                if (l2.next==null){
                    if (rest!=0)
                        sum.next = new ListNode(rest);
                    return start;
                }
                sum.next = new ListNode();
                sum = sum.next;
                l2=l2.next;
            }
            else if (l2 == null) {
                sum.val = l1.val + rest;
                rest=0;
                if (sum.val >= 10) {
                    rest = 1;
                    sum.val = sum.val - 10;
                }
                if (l1.next==null){
                    if (rest!=0)
                        sum.next = new ListNode(rest);
                    return start;
                }
                sum.next = new ListNode();
                sum = sum.next;
                l1=l1.next;
            }
        }
        return start;
    }
}
