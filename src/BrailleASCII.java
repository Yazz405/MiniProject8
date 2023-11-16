/**
 * Contains the main method to do each of the conversions from command-line prompts
 * 
 * @author Alma Ordaz
 * 
 */

import java.io.PrintWriter;

public class BrailleASCII {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    if(args.length != 0){
      System.err.println("incorrect number of parameters");
      System.exit(1);
    }
    
    if (args[0].equals("braille")) {
      pen.println(BrailleASCIITables.toBraille(args[1].charAt(0)));
    } else if (args[0].equals("ascii")) {
      pen.println(BrailleASCIITables.toASCII(args[1]));
    } else if (args[0].equals("unicode")) {
      pen.println(BrailleASCIITables.toUnicode(args[1]));
    } else {

    }
  }// main
}// class BrailleASCII
