public class BT5_Kth_LevelOF_Tree {
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

    public static void Kth_LevelOF_Tree(Node Root, int Level, int Key) { // O(n)....
        if (Root == null) {
            return;
        }
        if (Key == 0) {
            System.out.println("THE NODE AT LEVEL " + Key + " IS ::: " + Root.data);
            return;
        }
        if (Level == Key) {
            System.out.println("THE NODE AT LEVEL " + Key + " IS ::: " + Root.data);
            return;
        }
        if (Root.Left != null) {
            Kth_LevelOF_Tree(Root.Left, Level + 1, Key);
        }
        if (Root.Right != null) {
            Kth_LevelOF_Tree(Root.Right, Level + 1, Key);
        }
        return;
    }

    public static void main(String args[]) {
        Node NewNode = new Node(1);
        NewNode.Left = new Node(2);
        NewNode.Right = new Node(3);
        NewNode.Left.Left = new Node(4);
        NewNode.Left.Right = new Node(5);
        NewNode.Right.Left = new Node(6);
        NewNode.Right.Right = new Node(7);
        Kth_LevelOF_Tree(NewNode, 1, 3);
    }
}
