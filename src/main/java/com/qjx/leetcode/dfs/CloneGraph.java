package com.qjx.leetcode.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 深拷贝图(克隆图)
 *Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 *
 *
 *
 * Example:
 *
 *
 *
 * Input:
 * {"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
 *
 * Explanation:
 * Node 1's value is 1, and it has two neighbors: Node 2 and 4.
 * Node 2's value is 2, and it has two neighbors: Node 1 and 3.
 * Node 3's value is 3, and it has two neighbors: Node 2 and 4.
 * Node 4's value is 4, and it has two neighbors: Node 1 and 3.
 *
 * @author: qincasin
 * @date: 2019/8/23/ 11:05
 */
class Node {
  public int val;
  public List<Node> neighbors;

  public Node() {}

  public Node(int _val, List<Node> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }
};

/**
 * 基于树的深拷贝来考虑
 * 使用一个hashmap来记录，原node 和 新node的对应关系。
 *
 * 若原node已经作为key存在于hashmap里，那么说明它的拷贝(新node)也
 *
 * 已经存在，那么直接获得它的拷贝，否则，就要为这个node生成新的拷贝
 *
 * 然后，把拷贝放入hashmap中，并且使得拷贝(新node)的邻接链表添加原node的邻接链表里元素的拷贝。
 *
 */
public class CloneGraph {

  Map<Node,Node> map = new HashMap<>();
  public Node cloneGraph(Node node) {
    return DFS(node);
  }

  private Node DFS(Node oldNode) {
    if (oldNode == null) {
      return null;
    }
    if(map.containsKey(oldNode)){
      return map.get(oldNode);
    }
    Node newNode= new Node(oldNode.val,null);
    map.put(oldNode,newNode);
    if (oldNode.neighbors != null) {
      newNode.neighbors = new ArrayList<>();
      for (Node neighbor : oldNode.neighbors) {
        newNode.neighbors.add(DFS(neighbor));
      }
    }
    return newNode;
  }
}
