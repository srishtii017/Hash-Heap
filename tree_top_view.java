import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class tree_top_view {
    static class Pair {
        TreeNode node;
        int hd; // horizontal distance

        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read input and build the tree
        String[] input = sc.nextLine().split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(input[0]));
        queue.add(root);

        int index = 1;
        while (!queue.isEmpty() && index < input.length) {
            TreeNode current = queue.poll();
            if (!input[index].equals("-1")) {
                current.left = new TreeNode(Integer.parseInt(input[index]));
                queue.add(current.left);
            }
            index++;
            if (index >= input.length) break;

            if (!input[index].equals("-1")) {
                current.right = new TreeNode(Integer.parseInt(input[index]));
                queue.add(current.right);
            }
            index++;
        }

        // Function call to get the top view of the binary tree
        printTopView(root);
        sc.close();
    }

    public static void printTopView(TreeNode root) {
        // Map to store the top view nodes at each horizontal distance
        Map<Integer, Integer> topViewMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        // Initialize the queue with the root node and horizontal distance of 0
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            TreeNode currentNode = current.node;
            int hd = current.hd;

            // If this horizontal distance is not already present, add it to the map
            if (!topViewMap.containsKey(hd)) {
                topViewMap.put(hd, currentNode.data);
            }

            // Enqueue left and right children with their respective horizontal distances
            if (currentNode.left != null) {
                queue.add(new Pair(currentNode.left, hd - 1));
            }
            if (currentNode.right != null) {
                queue.add(new Pair(currentNode.right, hd + 1));
            }
        }

        // Output the top view nodes in the order of their horizontal distance
        for (int value : topViewMap.values()) {
            System.out.print(value + " ");
        }
    }
}
