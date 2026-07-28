class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node temp = head;

        while (temp != null) {
            Node copy = new Node(temp.val);

            copy.next = temp.next;
            temp.next = copy;

            temp = copy.next;
        }
        temp = head;

        while (temp != null) {

            if (temp.random != null)
                temp.next.random = temp.random.next;

            temp = temp.next.next;
        }
        Node copyHead = head.next;
        Node original = head;
        Node copy = copyHead;

        while (original != null) {

            original.next = copy.next;
            original = original.next;

            if (original != null)
                copy.next = original.next;

            copy = copy.next;
        }
        return copyHead;
    }
}