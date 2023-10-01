import java.util.*;

public class BT4_TopView_OF_Tree {

    static class Node {
        int data;
        Node Left;
        Node Right;

        public Node(int CurrData) {
            this.data = CurrData;
            this.Left = null;
            this.Right = null;
        }
    }

    static class NodeInfo {
        Node node;
        int HozlDist;

        public NodeInfo(Node temp, int HD) {
            this.node = temp;
            this.HozlDist = HD;
        }
    }

    public static void TopView_OF_Tree(Node Root) {
        Queue<NodeInfo> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        // int Min = 0;
        // int Max = 0;
        int Min = Integer.MAX_VALUE;
        int Max = Integer.MIN_VALUE;
        q.add(new NodeInfo(Root, 0));
        q.add(null);
        while (q.isEmpty() != true) {
            NodeInfo curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (map.containsKey(curr.HozlDist) != true) {
                    map.put(curr.HozlDist, curr.node);
                }
                if (curr.node.Left != null) {
                    q.add(new NodeInfo(curr.node.Left, (curr.HozlDist - 1)));
                    Min = Math.min(Min, (curr.HozlDist - 1));
                }
                if (curr.node.Right != null) {
                    q.add(new NodeInfo(curr.node.Right, (curr.HozlDist + 1)));
                    Max = Math.max(Max, (curr.HozlDist + 1));
                }
            }
            // if (map.containsKey(curr.HozlDist) != true) {
            // map.put(curr.HozlDist, curr.node);
            // }
            // if (curr.node.Left != null) {
            // q.add(new NodeInfo(curr.node.Left, (curr.HozlDist - 1)));
            // Min = Math.min(Min, (curr.HozlDist - 1));
            // }
            // if (curr.node.Right != null) {
            // q.add(new NodeInfo(curr.node.Right, (curr.HozlDist + 1)));
            // Max = Math.min(Max, (curr.HozlDist + 1));
            // }
        }
        System.out.print("THE TOP VIEW OF THE BINARY TREE IS ::: ");
        for (int i = Min; i <= Max; i++) {
            System.out.print(map.get(i).data + " ");
        }
    }

    public static void main(String args[]) {
        Node NewNode = new Node(1);
        NewNode.Left = new Node(2);
        NewNode.Right = new Node(3);
        NewNode.Left.Left = new Node(4);
        NewNode.Left.Right = new Node(5);
        NewNode.Right.Left = new Node(6);
        NewNode.Right.Right = new Node(7);
        TopView_OF_Tree(NewNode);
    }
}