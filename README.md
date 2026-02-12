# leetcode

This repository contains all solved problems, only med+  problems are addressed briefly how they are done.

* LRUCache
  Inorder to meet with O(1) time complexity, a double linked list and a node array are used. Demonstrated as below.
  ```Java
  class Node {
        Node prev;
        Node next;
        int key;
        int val;
  }
  Node[] nodes = new Node[10001];
  ```
  The key idea is to maintain the list properly. Whenever a key is accessed, the node with the key will be added,</br>
  or moved if existed, to the list tail. And node[key] enables us to find then node when a value is queried </br>
  by key. Not only the list operation but the node finding are with O(1), hence O(1) satisfies.
  




