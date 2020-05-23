package com.example.buildTree;

class Solution {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || preorder.length == 0
                || inorder == null || inorder.length == 0
                || preorder.length != inorder.length) {
            return null;
        }
        return helper(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int pStart, int pEnd,
                            int[] inorder, int iStart, int iEnd) {

        // 设置递归终止条件
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pStart]);
        int index = 0;  // 记录根节点在 preorder 与 inorder 中的偏移量
        while (preorder[pStart] != inorder[iStart + index]) {
            index++;
        }
        root.left = helper(preorder, pStart + 1, pStart + index,
                inorder, iStart, iStart + index - 1);
        root.right = helper(preorder, pStart + index + 1, pEnd,
                inorder, iStart + index + 1, pEnd);
        return root;
    }
}