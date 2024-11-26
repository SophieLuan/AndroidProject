package com.example.smartcityapp.Search;

import com.example.smartcityapp.loadData.DataActivity;

/**
 * AVLNode class representing a node in an AVL tree.
 * Each node contains a key, value, references to left and right children, and a height attribute for balancing.
 *
 * author: Lujin Sun (u7897414) and Zhizhao Sun (u7799455)
 */
public class AVLNode {
    String key;
    DataActivity value;
    AVLNode left;
    AVLNode right;
    int height;

    public AVLNode(String key) {
        this.key = key;
        this.height = 1;
    }

    /**
     * Constructor for creating an AVLNode with a key, value, left child, and right child.
     *
     * @param key   The unique identifier for the activity.
     * @param value The DataActivity object representing the activity.
     * @param left  Reference to the left child node.
     * @param right Reference to the right child node.
     */
    public AVLNode(String key, DataActivity value, AVLNode left, AVLNode right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
        this.height = 1;
    }

    public AVLNode(String key, DataActivity value) {
        this.key = key;
        this.value = value;
        this.height = 1;
    }
}
