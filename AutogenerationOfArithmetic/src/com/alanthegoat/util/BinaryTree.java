package com.alanthegoat.util;

public class BinaryTree<T> {
    private Node<T> root;

    private static class Node<T>{
        T value;
        Node<T> leftChild;
        Node<T> rightChild;

        Node(T value){
            this.value = value;
            leftChild = rightChild = null;
        }
        Node(T value,Node<T> leftChild,Node<T> rightChild){
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }
    public BinaryTree(){

    }

    public boolean isEmpty(){
        return root==null?true:false;
    }

    public void insert(T s){
        Node<T> temp = root;
        if(isEmpty()){
            root = new Node<T>(s);
            return;
        }
        while(true) {
            if (temp.leftChild == null) {
                temp.leftChild = new Node<T>(s);
                break;
            } else if (temp.rightChild == null) {
                temp.rightChild = new Node<T>(s);
                break;
            }else {
                if (temp.leftChild.leftChild != null && temp.leftChild.rightChild != null)
                    temp = temp.rightChild;
                else
                    temp = temp.leftChild;
            }
        }
    }

    private String inorderTraversal(Node<T> node){
        if(node==null)
            return "";
        String ret = "";
        ret += inorderTraversal(node.leftChild);
        ret +=node.value+" ";
        ret += inorderTraversal(node.rightChild);
        return ret;
    }
    private String postorderTraversal(Node<T> node){
        if(node==null)
            return "";
        String ret = "";
        ret += postorderTraversal(node.leftChild);
        ret += postorderTraversal(node.rightChild);
        ret +=node.value+" ";
        return ret;
    }
    public String inorderTraversal(){
        return inorderTraversal(root);
    }

    public String postorderTraversal(){
        return postorderTraversal(root);
    }
}
