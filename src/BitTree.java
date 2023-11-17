
/**
 * An implementation of a BitTree using nodes
 * 
 * @author Alma Ordaz
 * 
 */

import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

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
    this.root = new BitTreeNode("");
  }// BitTree

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
      } else if (bits.substring(i, i + 1).equals("0")) {
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

  }// set

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
          throw new Exception("path does not exist");
        }
      } else if (bits.substring(i, i + 1).equals("0")) {
        if (current.right != null) {
          current = current.right;
        } else {
          throw new Exception("path does not exist");
        }
      } else {
        throw new Exception("Bits can only contain 1 or 0");
      }
    }

    return current.left.value;

  }// get

  /*
   * prints out the contents of the tree in CSV format
   */
  public void dump(PrintWriter pen) {
    String[] bits = new String[this.size];

    dumpHelper(pen, this.root.left, bits, 0);
    dumpHelper(pen, this.root.right, bits, 0);
  }// dump

  /*
   * reads a series of lines of the form bits,value and stores them in the tree
   */
  public void load(InputStream source) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(source));
    String line;
    while (reader.ready()) {
      line = reader.readLine();
      set(line.substring(0, this.size), line.substring(this.size + 1, line.length()));
    }
  }// load

  // +---------+-----------------------------------------------------
  // | Helpers |
  // +---------+

  void dumpHelper(PrintWriter pen, BitTreeNode node, String[] bits, int level) {
    if (node == null) {
      return;
    } else if (node.isLeaf()) {
      for (int i = 0; i < bits.length; i++) {
        pen.print(bits[i]);
      }
      pen.println("," + node.value);
    } else if ((node.left != null) || (node.right != null)) {
      bits[level] = node.value;

      dumpHelper(pen, node.left, bits, ++level);
      --level;
      dumpHelper(pen, node.right, bits, ++level);

    } // else-if
  }// dumpHelper
  
}// class BitTree
