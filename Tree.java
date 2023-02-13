package Home_Tasks.HT_19;

import java.util.*;

public class Tree <T extends Comparable<T>>{
    private Node root;

    private class Node {
        private T value;
        private Node left;
        private Node right;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return " " + value + " ";
        }
    }

    public void add(T value) {
        Objects.requireNonNull(value);
        root = appendNode(root, value);
    }

    private Node appendNode(Node current, T value) {
        if (current == null) {
            return new Node(value);
        }

        int compare = value.compareTo(current.value);
        if (compare < 0) {
            current.left = appendNode(current.left, value);
        } else if (compare > 0) {
            current.right = appendNode(current.right, value);
        }

        return current;
    }

    public void printTree(){
        List<Node> nodes = new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            List<Node> childrens = new ArrayList<>();
            for (Node node: nodes) {
                if (node.left != null) {
                    childrens.add(node.left);
                }
                if (node.right != null) {
                    childrens.add(node.right);
                }
                System.out.print(node);
            }
            System.out.println();
            nodes = childrens;
        }
    }

    public boolean contains(T value) {
        return containsNode(value, root);
    }

    private boolean containsNode(T value, Node next) {
        boolean result = false;
        int compare = next.value.compareTo(value);
        if (compare == 0) {
            return true;
        }
        if (compare > 0) {
            if (next.left != null) {
                result = containsNode(value, next.left);
            }
        }
        if (compare < 0) {
            if (next.right != null) {
                result = containsNode(value, next.right);
            }
        }
        return result;
    }
}