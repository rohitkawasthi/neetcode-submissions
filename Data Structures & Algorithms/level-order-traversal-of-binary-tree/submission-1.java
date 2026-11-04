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

    public List<List<Integer>> levelOrder(TreeNode root) {
        // return bfsLevelOrder(root);
        return dfsLevelOrder(root);
    }

    private List<List<Integer>> dfsLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        dfsHelper(root, result, 0);

        return result;
    }
    
    private void dfsHelper(TreeNode root, List<List<Integer>> result, int level) {
        if(root == null) {
            return;
        }
        
        List<Integer> levelNodes = null;
        if(result.size()>level) {
            levelNodes = result.get(level);
        } else {
            levelNodes = new ArrayList<>();
            result.add(levelNodes);
        }
        levelNodes.add(root.val);

        dfsHelper(root.left, result, level+1);
        dfsHelper(root.right, result, level+1);
    }
    
    private List<List<Integer>> bfsLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null) {
            return result;
        }
        
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));

        int prevLevel = -1;
        List<Integer> currLevelNodes = null;

        while(!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.v1();
           
            int level = pair.v2();
            if(prevLevel+1 == level) {
                currLevelNodes = new ArrayList<>();
                result.add(currLevelNodes);
            }
            currLevelNodes.add(node.val);
            prevLevel = level;
            
            if(node.left != null) {
                queue.add(new Pair<>(node.left, level+1));
            }
            if(node.right != null) {
                queue.add(new Pair<>(node.right, level+1));
            }
        }

        return result;
    }
}
