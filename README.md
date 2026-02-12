# leetcode

This repository contains all solved problems, only med+ problems are addressed briefly how they are done. Readability is not considered when coding.

* LRUCache https://leetcode.com/problems/lru-cache/ </br>
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
  The key idea is to maintain the list properly. When a put(int key, int value) occurs, the node with the key will be added,</br>
  or moved if existed, to the list tail. When a get(int key) operation comes, node[key] enables us to find the node quickly, </br>
  we then move the found node to the list tail. Not only the list operation but the node finding are with O(1), hence O(1) satisfies.
  
* Word Search https://leetcode.com/problems/word-search/description/ </br>
  Iterate all board characters, when a character is found equal to the word's first character, do a BFS.

* Count vowel strings in ranges https://leetcode.com/problems/count-vowel-strings-in-ranges/description/ </br>
  Iterate through the string array with an index i, and use a counter array to sum up the number of vowel string at the index. 

* Zigzag Conversion https://leetcode.com/problems/zigzag-conversion/description/ </br>
  It's all about array loop control, not too complex.

* Peeking Iterator https://leetcode.com/problems/peeking-iterator/description/ </br>
  Much more of a design problem.
