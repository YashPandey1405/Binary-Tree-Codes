import java.util.*;

public class BT2_TreeDiametre_Approach2 { // O(n).....

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

    static class DiamInfo {
        int diam;
        int height;

        public DiamInfo(int Diam, int Ht) {
            this.diam = Diam;
            this.height = Ht;
        }
    }

    public static DiamInfo Diameter(Node Root) {
        if (Root == null) {
            return new DiamInfo(0, 0);
        }

        DiamInfo LeftInfo = Diameter(Root.Left);
        DiamInfo RightInfo = Diameter(Root.Right);
        int SelfDiam = LeftInfo.height + RightInfo.height + 1;

        int MaxDiam = Math.max(SelfDiam, Math.max(LeftInfo.diam, RightInfo.diam));
        int Height = Math.max(LeftInfo.height, RightInfo.height) + 1;

        return new DiamInfo(MaxDiam, Height);
    }

    public static void main(String args[]) {
        Node NewNode = new Node(1);
        NewNode.Left = new Node(2);
        NewNode.Right = new Node(3);
        NewNode.Left.Left = new Node(4);
        NewNode.Left.Right = new Node(5);
        NewNode.Right.Left = new Node(6);
        NewNode.Right.Right = new Node(7);
        int MaxDiameter = Diameter(NewNode).diam;
        System.out.println("THE DIAMETER OF THE BINARY TREE IS ::: " + MaxDiameter);
    }
}