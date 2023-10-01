import java.util.*;

public class BT6_Lowest_CommAnsestor {
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

    public static boolean GetPath(Node Root, int n, ArrayList<Node> Path) {
        if (Root == null) {
            return false;
        }
        Path.add(Root);
        if (Root.data == n) {
            return true;
        }
        boolean FoundLeft = GetPath(Root.Left, n, Path);
        boolean FoundRight = GetPath(Root.Right, n, Path);
        if (FoundRight || FoundLeft) {
            return true;
        }
        Path.remove(Path.size() - 1);
        return false;
    }

    // In Lowest_Common_Ansestor() Function,Time Complexity Is O(n) And Space
    // Complexity Is O(n)....
    public static Node Lowest_Common_Ansestor(Node Root, int n1, int n2) {
        ArrayList<Node> Path1 = new ArrayList<>();
        ArrayList<Node> Path2 = new ArrayList<>();
        GetPath(Root, n1, Path1);
        GetPath(Root, n2, Path2);
        // int End = Path1.size() && Path2.size();
        int i = 0;
        for (; i < Path1.size() && i < Path2.size(); i++) {
            if (Path1.get(i).data != Path2.get(i).data) {
                break;
            }
        }
        Node LCA = Path1.get(i - 1);
        return LCA;
    }

    // In Lowest_Common_AnsestorII() Function,Time Complexity Is O(n)
    // And Space Complexity Is O(1)....
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
        // Node Temp = Lowest_Common_Ansestor(NewNode, n1, n2);
        Node Temp = Lowest_Common_AnsestorII(NewNode, n1, n2);
        System.out.println("THE LOWEST COMMOM ANSESTOR OF " + n1 + " AND " + n2 + " IS ::: " + Temp.data);
    }
}
