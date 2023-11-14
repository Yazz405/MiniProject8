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


  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /*
   * builds a tree that will store mappings from strings of n bits to strings
   */
  public BitTree(int n) {

  }

  // +----------------+----------------------------------------------
  // | Static Methods |
  // +----------------+

  /*
   * follows the path through the tree given by bits (adding nodes as appropriate) 
   * and adds or replaces the value at the end with
   * 
   * @throws Exception if bits is the inappropriate length or contains values other than 0 or 1
   */
  public static void set(String bits, String value){

  }

  /*
   * follows the path through the tree given by bits, returning the value at the end.
   * 
   * @Trows Exception if there is no such path, or if bits is the incorrect length
   */
  public static String get(String bits){
    
  }

  /*
   *  prints out the contents of the tree in CSV format
   */
  public static void dump(PrintWriter pen){

  }

  /*
   * reads a series of lines of the form bits,value and stores them in the tree
   */
  public static void load(InputStream source){

  }
}// class BitTree
