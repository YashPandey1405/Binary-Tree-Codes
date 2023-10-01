import java.util.*;

public class BT7_DistanceBw_2Nodes {
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

    public static Node Lowest_Common_AnsestorII(Node Root, int n1, int n2) {
        if (Root == null || Root.data == n1 || Root.data == n2) {
            return Root;
        }
        Node LeftLCA = Lowest_Common_AnsestorII(Root.Left, n1, n2);
        Node RightLCA = Lowest_Common_AnsestorII(Root.Right, n1, n2);
        if (RightLCA == null) {
            return LeftLCA;
        }
        if (LeftLCA == null) {
            return RightLCA;
        }
        return Root;
    }

    public static int LocalDistance(Node Root, int n) {
        if (Root == null) {
            return -1;
        }
        if (Root.data == n) {
            return 0;
        }
        int LeftDist = LocalDistance(Root.Left, n);
        int RightDist = LocalDistance(Root.Right, n);
        if (LeftDist == -1 && RightDist == -1) {
            return -1;
        } else if (LeftDist == -1) {
            return RightDist + 1;
        } else {
            return LeftDist + 1;
        }
    }

    public static int MinDist(Node Root, int n1, int n2) { // O(n)....
        Node LCA = Lowest_Common_AnsestorII(Root, n1, n2);
        int Dist1 = LocalDistance(Root, n1);
        int Dist2 = LocalDistance(Root, n2);
        return Dist1 + Dist2;
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
        System.out.print("ENTER THE FIRST NODE ::: ");
        int n1 = sc.nextInt();
        System.out.print("ENTER THE SECOND NODE ::: ");
        int n2 = sc.nextInt();
        int ans = MinDist(NewNode, n1, n2);
        System.out.println("THE DISTANCE BETWEEN THE NODE " + n1 + " AND " + n2 + " IS ::: " + ans);
    }
}
