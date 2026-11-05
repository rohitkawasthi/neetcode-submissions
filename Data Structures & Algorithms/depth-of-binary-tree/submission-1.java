/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    private record Pair<V1, V2>(V1 v1, V2 v2) {}

    public int maxDepth(TreeNode root) {
        int maxDepth = 0;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 0));
        
        while(!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.v1;
            int depth = pair.v2;

            if(node == null) {
                continue;
            }

            maxDepth = Math.max(maxDepth, depth+1);
            
            stack.push(new Pair<>(node.right, depth+1));         
            stack.push(new Pair<>(node.left, depth+1));
        }

        return maxDepth;
    }
}
