import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelTraversal {
     BinaryTree bt;
     public  BinaryTreeLevelTraversal(BinaryTree bt) {
         bt =bt;
     }
     public static class BinaryTree {
         public Node getRoot() {
             return root;
         }

         public void setRoot(Node root) {
             this.root = root;
         }

         Node root;
           class   Node {
             int value;
             Node left;
             Node right;

             Node(int value) {
                 this.value = value;
                 right = null;
                 left = null;
             }
         }
         public void add(int value) {
             root = addRecursive(root, value);
         }
         private Node addRecursive(Node current, int value) {
             if (current == null) {
                 return new Node(value);
             }

             if (value < current.value) {
                 current.left = addRecursive(current.left, value);
             } else if (value > current.value) {
                 current.right = addRecursive(current.right, value);
             } else {
                 // value already exists
                 return current;
             }

             return current;
         }
         ;
     };


    public static void main(String [] args) {
            BinaryTree bt = new BinaryTree();

            bt.add(6);
            bt.add(4);
            bt.add(8);
            bt.add(3);
            bt.add(5);
            bt.add(7);
            bt.add(9);
           List<List<Integer>> result = new ArrayList<>();
           BinaryTreeLevelTraversal btt = new  BinaryTreeLevelTraversal(bt);
           btt.levelTraverse(bt.root, 0, result);
           System.out.println(result);
        }

    private void levelTraverse(BinaryTree.Node root, int level, List<List<Integer>> result) {
        if (root == null) return;
        List<Integer> list =  level <= result.size()-1 ? result.get(level) : new ArrayList<>();
        list.add(root.value);
        if(list.size() == 1) {
            result.add(list);
        }
        levelTraverse(root.left, level+1, result);
        levelTraverse(root.right, level+1, result);

    }

}
