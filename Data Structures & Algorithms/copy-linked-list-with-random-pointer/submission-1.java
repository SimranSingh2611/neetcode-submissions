/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        Node dummy = new Node(-1);
        Node newList = dummy;

        Node curr = head;
        Map<Node, Node> oldNodeToNewNode = new HashMap<>();
        while(curr != null) {
            Node newNode = new Node(curr.val);
            oldNodeToNewNode.put(curr, newNode);
            newList.next = newNode;
            newList = newList.next;
            curr = curr.next;
        }

        curr = head;
        Node currNew = dummy.next;

        while(curr != null) {
            Node randomNodeInOld = curr.random;
            Node randomNodeInNew = oldNodeToNewNode.get(randomNodeInOld);
            currNew.random = randomNodeInNew;
            currNew = currNew.next;
            curr = curr.next;
        }
        
        return dummy.next;
    }
}