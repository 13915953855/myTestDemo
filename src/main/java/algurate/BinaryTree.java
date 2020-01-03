package algurate;

import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: 徐森
 * @CreateDate: 2019/12/31
 * @Description:
 */
public class BinaryTree {

    public static TreeNode createBinaryTree(LinkedList<Integer> inputList){
        TreeNode node = null;
        if(CollectionUtils.isEmpty(inputList)) {return null;}
        Integer data = inputList.removeFirst();
        if(data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    public static void preOrderTraveral(TreeNode treeNode){
        if(treeNode == null) return;
        System.out.println(treeNode.data);
        if(treeNode.leftChild != null)
        preOrderTraveral(treeNode.leftChild);
        if(treeNode.rightChild != null)
        preOrderTraveral(treeNode.rightChild);
    }

    public static void inOrderTraveral(TreeNode treeNode){
        if(treeNode == null) return;
        if(treeNode.leftChild != null)
            inOrderTraveral(treeNode.leftChild);
        System.out.println(treeNode.data);

        if(treeNode.rightChild != null)
            inOrderTraveral(treeNode.rightChild);
    }
    public static void postOrderTraveral(TreeNode treeNode){
        if(treeNode == null) return;
        if(treeNode.leftChild != null)
            postOrderTraveral(treeNode.leftChild);

        if(treeNode.rightChild != null)
            postOrderTraveral(treeNode.rightChild);
        System.out.println(treeNode.data);
    }

    public static class TreeNode{
        Integer data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data){
            this.data = data;
        }
    }

    public static void preOrderTraveralWithStack(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()){
            while(treeNode != null){
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if(!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }

    }

    public static void level(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.println(node.data);
            if(node.leftChild != null){
                queue.offer(node.leftChild);
            }
            if(node.rightChild != null){
                queue.offer(node.rightChild);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 2, 9, null, null, 10, null, null, 8, null, 4};
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(arr));
        TreeNode treeNode = createBinaryTree(inputList);
        level(treeNode);
        System.out.println("前序遍历：");
        preOrderTraveral(treeNode);
        preOrderTraveralWithStack(treeNode);
        System.out.println("中序遍历：");
        inOrderTraveral(treeNode);
        System.out.println("后序遍历：");
        postOrderTraveral(treeNode);
    }
}
