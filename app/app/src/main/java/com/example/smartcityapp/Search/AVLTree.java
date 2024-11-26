package com.example.smartcityapp.Search;

import com.example.smartcityapp.loadData.DataActivity;

import java.util.ArrayList;
import java.util.List;
/**
 * AVLTree class representing an AVL (self-balancing binary search) tree.
 * This class supports inserting and searching for activities within the tree structure.
 * The tree is used to efficiently manage and retrieve DataActivity instances.
 *
 * author: Lujin Sun (u7897414)and Zhizhao Sun (u7799455)
 */
public class AVLTree {
    AVLNode root;
    List<DataActivity> results = new ArrayList<>();

    /**
     * Inserts a DataActivity into the AVL tree.
     *
     * @param activity The DataActivity to be inserted.
     */
    public void insert(DataActivity activity) {
        root = doInsert(root, activity);
    }

    /**
     * Recursive method to insert a DataActivity into the AVL tree.
     *
     * @param node    The current node being examined.
     * @param activity The DataActivity to be inserted.
     * @return The updated AVLNode after insertion and balancing.
     */
    protected AVLNode doInsert(AVLNode node, DataActivity activity) {
        String key = activity.getId();
        if (node == null) {
            return new AVLNode(key, activity);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = doInsert(node.left, activity);
        } else if (key.compareTo(node.key) > 0) {
            node.right = doInsert(node.right, activity);
        }else {
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        //do rotate: LL, RR, LR, RL
        if (balance > 1 && key.compareTo(node.left.key) < 0)
            return rotateRight(node);//LL

        if (balance < -1 && key.compareTo(node.right.key) > 0)
            return rotateLeft(node);//RR

        if (balance > 1 && key.compareTo(node.left.key) > 0){
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }//LR

        if (balance < -1 && key.compareTo(node.right.key) < 0){
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }//RL
        return node;
    }

    /**
     * Performs a left rotation on the given node.
     *
     * @param y The node to rotate.
     * @return The new root after the left rotation.
     */
    private AVLNode rotateLeft(AVLNode y){
        AVLNode x = y.right;
        AVLNode T2 = x.left;
        //rotate
        x.left = y;
        y.right = T2;
        //update height
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }
    //rotateRight
    private AVLNode rotateRight(AVLNode y){
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }
    private int height(AVLNode node){
        return node == null ? 0 : node.height;
    }

    private int getBalance(AVLNode node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    /**
     * Searches the AVL tree for activities that match the query.
     *
     * @param query The query string to search for.
     * @return A list of DataActivity objects that match the query.
     */
    public List<DataActivity> search(String query) {
        results.clear();
        doSearch(root, query);
        return results;
    }

    /**
     * Recursive method to search the AVL tree for activities that match the query.
     *
     * @param node  The current node being examined.
     * @param query The query string to search for.
     */
    protected void doSearch(AVLNode node, String query) {
        if (node == null){
            return;
        }

        doSearch(node.left, query);

        Tokenizer tokenizer = new Tokenizer(query);
        Parser parser = new Parser(tokenizer);

        if (parser.parse(node.value)) {
            results.add(node.value);
        }

        doSearch(node.right, query);
    }
}
