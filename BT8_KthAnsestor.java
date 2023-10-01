import java.util.Scanner;

public class BT8_KthAnsestor {
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

    public static int KthAnsestor(Node Root, int n, int k) {
        if (Root == null) {
            return -1;
        }
        if (Root.data == n) {
            return 0;
        }
        int LeftDist = KthAnsestor(Root.Left, n, k);
        int RightDist = KthAnsestor(Root.Right, n, k);
        if (LeftDist == -1 && RightDist == -1) {
            return -1;
        }
        int Max = Math.max(LeftDist, RightDist);
        if (Max + 1 == k) {
            System.out.println("THE " + k + "th ANSESTOR IS ::: " + Root.data);
        }
        return Max + 1;
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
        int ans = KthAnsestor(NewNode, 5, 2);
        // int ans = MinDist(NewNode, n1, n2);
        // System.out.println("THE DISTANCE BETWEEN THE NODE " + n1 + " AND " + n2 + "
        // IS ::: " + ans);
    }
}
