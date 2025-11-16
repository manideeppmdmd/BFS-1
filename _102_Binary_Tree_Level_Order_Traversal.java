/**** Method 1 ****/
//Time Complexity: O(n)
//Space Complexity: O(breath of the tree)

//Successfully submitted in LeetCode

//Use to queue to store all the TreeNodes, start by adding the root to queue, later while queue not empty get the size, and run loop of size iterations and remove each node from queue, if it has left or right or both add them to queue and then add the val to new arraylist, after this loop add the list to ans list. return ans list at the end.

/**** Method 2 ****/
//Time Complexity: O(n)
//Space Complexity: O(h)

//Successfully submitted in LeetCode

//Use to queue to store all the TreeNodes, start by adding the root to queue, later while queue not empty get the size, and run loop of size iterations and remove each node from queue, if it has left or right or both add them to queue and then add the val to new arraylist, after this loop add the list to ans list. return ans list at the end.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102_Binary_Tree_Level_Order_Traversal {

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) return ans;

    Queue<TreeNode> queue = new LinkedList<>();

    queue.add(root);

    while (!queue.isEmpty()) {
      int size = queue.size();

      List<Integer> list = new ArrayList<>();

      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
        list.add(node.val);
      }
      ans.add(list);
    }

    return ans;
  }

  public List<List<Integer>> levelOrder1(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) return ans;

    helper(root, 0, ans);

    return ans;
  }

  private void helper(TreeNode node, int level, List<List<Integer>> ans) {
    if (node == null) return;

    if (level == ans.size()) {
      ans.add(new ArrayList<>());
    }

    ans.get(level).add(node.val);
    helper(node.left, level + 1, ans);
    helper(node.right, level + 1, ans);
  }

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
