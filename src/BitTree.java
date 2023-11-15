
/**
 * An implementation of a BitTree usind nodes and leaves
 * 
 * @author Alma Ordaz
 * 
 */

import java.io.PrintWriter;
import java.io.InputStream;

public class BitTree {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /*
   * the root of the Tree
   */
  BitTreeNode root;

  /*
   * The Size of the bitTree
   */
  int size;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /*
   * builds a tree that will store mappings from strings of n bits to strings
   */
  public BitTree(int n) {
    this.size = n;
    this.root = new BitTreeNode("start");
  }

  // +----------------+----------------------------------------------
  // | Static Methods |
  // +----------------+

  /*
   * follows the path through the tree given by bits (adding nodes as appropriate)
   * and adds or replaces the value at the end with
   * 
   * @throws Exception if bits is the inappropriate length or contains values
   * other than 0 or 1
   */
  public void set(String bits, String value) throws Exception {

    BitTreeNode current;

    // error checking
    if (bits.length() != this.size) {
      throw new Exception("not the correct amount of bits");
    } // if

    current = this.root;

    for (int i = 0; i < bits.length(); i++) {

      if (bits.substring(i, i + 1).equals("1")) {
        if (current.left != null) {
          current = current.left;
        } else {
          current.left = new BitTreeNode(bits.substring(i, i + 1));
          current = current.left;
        }
      } else if(bits.substring(i, i + 1).equals("0")) {
        if (current.right != null) {
          current = current.right;
        } else {
          current.right = new BitTreeNode(bits.substring(i, i + 1));
          current = current.right;
        }
      } else {
        throw new Exception("Bits can only contain 1 or 0");
      }
    } // for

    current.left = new BitTreeNode(value);

  }

  /*
   * follows the path through the tree given by bits, returning the value at the
   * end.
   * 
   * @Trows Exception if there is no such path, or if bits is the incorrect length
   */
  public String get(String bits) throws Exception {
    BitTreeNode current;

    // error checking
    if (bits.length() != this.size) {
      throw new Exception("not the correct amount of bits");
    } // if

    current = this.root;
    for (int i = 0; i < this.size; i++) {
      if (bits.substring(i, i + 1).equals("1")) {
        if (current.left != null) {
          current = current.left;
        } else {
          throw new  Exception("path does not exist");
        }
      } else if(bits.substring(i, i + 1).equals("0")){
        if (current.right != null) {
          current = current.right;
        } else {
          throw new  Exception("path does not exist");
        }
      } else {
        throw new Exception("Bits can only contain 1 or 0");
      }
    }

    return current.left.value;

  }

  /*
   * prints out the contents of the tree in CSV format
   */
  public void dump(PrintWriter pen) {
    dumpHelper(pen, this.root, "");
  }

  void dumpHelper(PrintWriter pen, BitTreeNode node, String indent) {
    if (node == null) {
      pen.println(indent + "<>");
    } else {
      pen.println(indent + node.value);
      if ((node.left != null) || (node.right != null)) {
        dumpHelper(pen, node.left, indent + "  ");
        dumpHelper(pen, node.right, indent + "  ");
      } // if has children
    } // else
  } // dump

  /*
   * reads a series of lines of the form bits,value and stores them in the tree
   */
  public void load(InputStream source) {

  }

  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    BitTree tree = new BitTree(6);
    tree.set("110100", "hello");
    tree.dump(pen);
    pen.println(tree.get("110101"));

  }
}// class BitTree
