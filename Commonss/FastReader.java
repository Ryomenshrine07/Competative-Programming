
package Commonss;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class FastReader {

    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
            left = right = null;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    class DoublyListNode {
        int val;
        DoublyListNode next, prev;

        DoublyListNode(int x) {
            val = x;
            next = prev = null;
        }
    } 

    private final BufferedReader br;
    private StringTokenizer st;
    private List<List<Integer>> adjacencyList;

    public List<List<Integer>> createAdjacencyList(int[][] edges) {
        int maxNode = 0;
        for (int[] edge : edges) {
            maxNode = Math.max(maxNode, Math.max(edge[0], edge[1]));
        }
        adjacencyList = new ArrayList<>(maxNode + 1);
        for (int i = 0; i <= maxNode; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        return adjacencyList;
    }

    public List<List<Integer>> createDirectedAdjacencyList(int[][] edges) {
        int maxNode = 0;
        for (int[] edge : edges) {
            maxNode = Math.max(maxNode, edge[0]);
        }
        adjacencyList = new ArrayList<>(maxNode + 1);
        for (int i = 0; i <= maxNode; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
        }
        return adjacencyList;
    }
    
    private TreeNode buildBST(int[] values, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(values[mid]);
        node.left = buildBST(values, start, mid - 1);
        node.right = buildBST(values, mid + 1, end);
        return node;
    }

    public int[] oneDInput(int n) throws IOException {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }

    public int[][] twoDInput(int m, int n) throws IOException {
        int[][] array = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = nextInt();
            }
        }
        return array;
    }

    public String[] oneDStringInput(int n) throws IOException {
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = next();
        }
        return array;
    }
    
    
    public ListNode createSinglyLinkedList(int[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    public DoublyListNode createDoublyLinkedList(int[] values) {
        if (values.length == 0) return null;
        DoublyListNode head = new DoublyListNode(values[0]);
        DoublyListNode current = head;
        for (int i = 1; i < values.length; i++) {
            DoublyListNode newNode = new DoublyListNode(values[i]);
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
        }
        return head;
    }

    public FastReader(String filePath) throws IOException {
        br = new BufferedReader(new FileReader(filePath));
    }

    private String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) return null;
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public String nextLine() throws IOException {
        return br.readLine();
    }

    public void close() throws IOException {
        br.close();
    }
}
