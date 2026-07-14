import java.util.ArrayList;
import java.util.List;

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

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int counter = 1;
        List<Integer> list = new ArrayList<>();
        list.add(head.val);
        while (head.next != null) {
            head = head.next;
            list.add(head.val);
            counter++;
        }
        list.remove(list.size()-n);
        ListNode newHead=null;
        for (int i = list.size(); i > 0; i--) {
            newHead = new ListNode(list.get(i-1),newHead);
        }
        return newHead;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode firstNode=new ListNode(0);
        ListNode head = firstNode;
        while(list1!=null&&list2!=null){
            if(list1.val>list2.val){
                head.next=list2;
                head=head.next;
                list2=list2.next;

            } else if (list2.val>list1.val) {
               head.next=list1;
               head=head.next;
               list1=list1.next;
            }
            else {
                head.next=list1;
                head=head.next;
                list1=list1.next;
            }
        }
        if(list1!=null){
            head.next=list1;
        }
        if(list2!=null){
            head.next=list2;
        }
        return firstNode.next;
    }
}
