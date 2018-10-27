package com.algorithm.studyAlgorithm.BinarySearchTree;

/********************************************************************
 *
 * 이진검색트리 노드 삭제하기
 *
 * 삭제의 경우, 총 3가지 경우가 존재한다.
 * 1. 자식 노드가 없는 경우
 *    그냥 삭제
 * 2. 자식 노드가 1개인 경우
 *    자신의 자식노드를 자신의 위치로 만든다.
 * 3. 자식 노드가 2개인 경우
 *    삭제하려는 노드의 successor를 가져온다. 여기서 successor란 자신보다 큰 값들 중 가장 작은 값을 뜻한다.
 *    successor는 왼쪽 노드를 가질 수 없다. 왜냐하면 트리에서 오른쪽 노드로 간 다음 가장 왼쪽 노드를 끝까지
 *    내려가기 때문이다. successor를 삭제하려는 노드 자리에 넣어주고 원래 successor의 오른쪽 노드는
 *    successor의 자리로 온다.
 *
 * 시간복잡도: O(h) 여기서 h는 높이
 * 최악의 경우: O(n)
 *
 * 강좌 출처: inflearn 권오흠 교수님 알고리즘 강좌
 * 코드 출처: https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
 *
 *********************************************************************/
public class TreeDelete {

    public static void main(String[] args)
    {
        PrivateBinarySearchTree tree = new PrivateBinarySearchTree();

		/* Let us create following BST
			50
		/	 \
		30	 70
		/ \ / \
		20 40 60 80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal of the given tree");
        tree.inorder();

        System.out.println("\nDelete 20");
        tree.deleteKey(20);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 30");
        tree.deleteKey(30);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 50");
        tree.deleteKey(50);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();
    }

    // Java program to demonstrate delete operation in binary search tree
    private static class PrivateBinarySearchTree
    {
        /* Class containing left and right child of current node and key value*/
        private class Node
        {
            int key;
            Node left, right;

            public Node(int item)
            {
                key = item;
                left = right = null;
            }
        }

        // Root of BST
        Node root;

        // Constructor
        PrivateBinarySearchTree()
        {
            root = null;
        }

        // This method mainly calls deleteRec()
        void deleteKey(int key)
        {
            root = deleteRec(root, key);
        }

        /* A recursive function to insert a new key in BST */
        Node deleteRec(Node root, int key)
        {
            /* Base Case: If the tree is empty */
            if (root == null) return root;

            /* Otherwise, recur down the tree */
            if (key < root.key)
                root.left = deleteRec(root.left, key);
            else if (key > root.key)
                root.right = deleteRec(root.right, key);

                // if key is same as root's key, then This is the node
                // to be deleted
            else
            {
                // node with only one child or no child
                if (root.left == null)
                    return root.right;
                else if (root.right == null)
                    return root.left;

                // node with two children: Get the inorder successor (smallest
                // in the right subtree)
                root.key = minValue(root.right);

                // Delete the inorder successor
                root.right = deleteRec(root.right, root.key);
            }

            return root;
        }

        int minValue(Node root)
        {
            int minv = root.key;
            while (root.left != null)
            {
                minv = root.left.key;
                root = root.left;
            }
            return minv;
        }

        // This method mainly calls insertRec()
        void insert(int key)
        {
            root = insertRec(root, key);
        }

        /* A recursive function to insert a new key in BST */
        Node insertRec(Node root, int key)
        {

            /* If the tree is empty, return a new node */
            if (root == null)
            {
                root = new Node(key);
                return root;
            }

            /* Otherwise, recur down the tree */
            if (key < root.key)
                root.left = insertRec(root.left, key);
            else if (key > root.key)
                root.right = insertRec(root.right, key);

            /* return the (unchanged) node pointer */
            return root;
        }

        // This method mainly calls InorderRec()
        void inorder()
        {
            inorderRec(root);
        }

        // A utility function to do inorder traversal of BST
        void inorderRec(Node root)
        {
            if (root != null)
            {
                inorderRec(root.left);
                System.out.print(root.key + " ");
                inorderRec(root.right);
            }
        }

    }

}
