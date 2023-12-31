package javasolution.easy.binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TreeNode root =
                new TreeNode(1,
                        new TreeNode(3,
                                new TreeNode(4,
                                        new TreeNode(5, null, null),
                                        new TreeNode(6, null, null)
                                ),
                                new TreeNode(7,
                                        null,
                                        null)),
                        new TreeNode(8,
                                new TreeNode(9,
                                        null,
                                        null),
                                null)
                );

        System.out.println(inorderTraversal(root));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        checkTree(root, list);
        return list;
    }

    private static void checkTree(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        checkTree(root.left, list);
        list.add(root.val);
        checkTree(root.right, list);
    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
