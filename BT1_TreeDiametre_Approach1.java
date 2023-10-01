import java.util.*;

public class BT1_TreeDiametre_Approach1 {
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

    public static int Height(Node Root) {
        if (Root == null) {
            return 0;
        }
        int LeftHt = Height(Root.Left);
        int RightHt = Height(Root.Right);
        return Math.max(LeftHt, RightHt) + 1;
    }

    public static int Diameter(Node Root) {
        if (Root == null) {
            return 0;
        }
        int LeftDiam = Diameter(Root.Left);
        int LeftHt = Height(Root.Left);
        int RightDiam = Diameter(Root.Right);
        int RightHt = Height(Root.Right);
        int SelfDiam = LeftHt + RightHt + 1;
        return Math.max(SelfDiam, Math.max(LeftDiam, RightDiam));
    }

    public static void main(String args[]) {
        Node NewNode = new Node(1);
        NewNode.Left = new Node(2);
        NewNode.Right = new Node(3);
        NewNode.Left.Left = new Node(4);
        NewNode.Left.Right = new Node(5);
        NewNode.Right.Left = new Node(6);
        NewNode.Right.Right = new Node(7);
        int Diam = Diameter(NewNode);
        System.out.println("THE MAX DIAMETER OF THE BINARY TREE IS ::: " + Diam);
    }
}