public class BT3_Tree_In_AnotherTree {
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

    public static boolean isIdentical(Node Root, Node SubRoot) {
        if (Root == null && SubRoot == null) {
            return true;
        } else if (Root == null || SubRoot == null || Root.data != SubRoot.data) {
            return false;
        }
        if (isIdentical(Root.Left, SubRoot.Left) == false) {
            return false;
        }
        if (isIdentical(Root.Right, SubRoot.Right) == false) {
            return false;
        }
        return true;
    }

    public static boolean IsSubTree(Node Root, Node SubRoot) {
        if (Root == null) {
            return false;
        }
        if (Root.data == SubRoot.data) {
            if (isIdentical(Root, SubRoot)) {
                return true;
            }
        }
        // boolean LeftAns = IsSubTree(Root.Left,SubRoot);
        // boolean RightAns = IsSubTree(Root.Right,SubRoot);
        return IsSubTree(Root.Left, SubRoot) || IsSubTree(Root.Right, SubRoot);
    }

    public static void main(String args[]) {

        Node NewNode = new Node(1);
        NewNode.Left = new Node(2);
        NewNode.Right = new Node(3);
        NewNode.Left.Left = new Node(4);
        NewNode.Left.Right = new Node(5);
        NewNode.Right.Left = new Node(6);
        NewNode.Right.Right = new Node(7);

        Node SubNode = new Node(2);
        SubNode.Left = new Node(4);
        SubNode.Right = new Node(5);
        boolean ans = IsSubTree(NewNode, SubNode);
        System.out.println(ans);
    }

}