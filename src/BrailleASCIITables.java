import java.io.FileInputStream;

/**
 * An implementation of conversions from ASCII characters, String of bits, and
 * unicode braille character
 * 
 * @author Alma Ordaz
 * 
 */

public class BrailleASCIITables {

  // +----------------+----------------------------------------------
  // | Static Methods |
  // +----------------+

  /*
   * converts an ASCII character to a string of bits representing the
   * corresponding braille character
   */
  public static String toBraille(char letter) throws Exception {
    FileInputStream source = new FileInputStream("ASCII to Braille.txt");
    BitTree tree = new BitTree(8);
    int ascii = (int) Character.toUpperCase(letter);
    tree.load(source);

    String result = tree.get("0" + Integer.toBinaryString(ascii));
    return result;
  }// toBraille

  /*
   * converts a string of bits representing a braille character to the
   * corresponding ASCII character
   */
  public static String toASCII(String bits) throws Exception {
    FileInputStream source = new FileInputStream("Braille to ASCII.txt");
    BitTree tree = new BitTree(6);
    tree.load(source);
    return tree.get(bits);
  }// toASCII

  /*
   * converts a string of bits representing a braille character to the
   * corresponding Unicode braille character for those bits
   */
  public static String toUnicode(String bits) throws Exception{
    FileInputStream source = new FileInputStream("Braille to Unicode.txt");
    BitTree tree = new BitTree(6);
    tree.load(source);
    return tree.get(bits);
  }// toUnicode
}// class BrailleASCIITables
