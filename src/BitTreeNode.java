/**
 * An implementation of a node for a Tree with an inner leaf class
 * 
 * @author Alma Ordaz
 * 
 */

public class BitTreeNode {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /*
   * the value of the node
   */
  String value;

  /*
   * the left subtree
   */
  BitTreeNode left;

  /*
   * the right subtree
   */
  BitTreeNode right;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /*
   * creates a new node
   */
  public BitTreeNode(String value){
    this.value = value;
    this.left = null;
    this.right = null;

  }

  class BitTreeLeaf {

  }// class BitTreeLeaf
}// class BitTreeNode
