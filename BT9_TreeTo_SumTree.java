import java.util.Scanner;

public class BT9_TreeTo_SumTree {
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

    public static int TreeTo_SumTree(Node Root) {
        if (Root == null) {
            return 0;
        }
        int LeftSubTree_Sum = TreeTo_SumTree(Root.Left);
        int RightSubTree_Sum = TreeTo_SumTree(Root.Right);
        int Prev_RootValue = Root.data;
        Root.data = LeftSubTree_Sum + RightSubTree_Sum;
        return (Prev_RootValue + Root.data);
    }

    public static void Pre_OrderTraversal(Node Root) {
        if (Root == null) {
            return;
        }
        Pre_OrderTraversal(Root.Left);
        System.out.print(Root.data + " ");
        Pre_OrderTraversal(Root.Right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node NewNode = new Node(1);
        NewNode.Left = new Node(2);
        NewNode.Right = new Node(3);
        NewNode.Left.Left = new Node(4);
        NewNode.Left.Right = new Node(5);
        NewNode.Right.Left = new Node(6);
        NewNode.Right.Right = new Node(7);
        int Temp = TreeTo_SumTree(NewNode);
        Pre_OrderTraversal(NewNode);
        // System.out.println("YASH PANDEY");
    }
}
