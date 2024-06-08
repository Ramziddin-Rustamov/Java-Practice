package BFS;

import com.sun.source.tree.Tree;

import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
    }
}

class BST{
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) {
            root.left=deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right=deleteNode(root.right, key);
        } else {
            if(root.left == null && root.right == null){
                root = null;
            } else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            }else{
                TreeNode successor = this.findSuccessor(root.right);
                root.val = successor.val;
                root.right = deleteNode(root.right, successor.val);
            }
        }
        return root;
    }


    private TreeNode findSuccessor(TreeNode node){
        while (node.left != null){
            node = node.left;
        }
        return node;
    }
    public static TreeNode insertNode(TreeNode root, int val){
        if(root == null){
            return new TreeNode(val);
        }
        if(val < root.val){
            root.left = insertNode(root.left, val);
        } else if (val > root.val) {
            root.right = insertNode(root.right,val);
        }

        return root;
    }

    public static void printInOrder(TreeNode root){
        if(root != null){
            printInOrder(root.left);
            System.out.println(root.val + " ");
            printInOrder(root.right);
        }
    }


}

public class Main {
    public static void main(String[] args) {
//        System.out.println("a");

        BST bst = new BST();
        TreeNode root = null;

        root =     bst.insertNode(root,1);
        root =    bst.insertNode(root,2);
        root =    bst.insertNode(root,3);
        root =    bst.insertNode(root,6);
        root =    bst.insertNode(root,5);
        root =    bst.insertNode(root,5);
        root =    bst.insertNode(root,7);
        root =    bst.insertNode(root,8);

        System.out.println("Real BST here !");

         bst.printInOrder(root);

    }
}
