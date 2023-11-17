
/**
 * Contains the main method to do each of the conversions from command-line prompts
 * 
 * @author Alma Ordaz
 * 
 */

import java.io.PrintWriter;

public class BrailleASCII {
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    String str = args[1];

    //error checking
    if (args.length != 2) {
      System.err.println("incorrect number of parameters");
      System.exit(1);
    }//if


    if (args[0].equals("braille")) {
      String result = "";

      for (int i = 0; i < str.length(); i++) {
        result += BrailleASCIITables.toBraille(str.charAt(i));
      }//for

      pen.println(result);
    } else if (args[0].equals("ascii")) {
      String result = "";

      for (int i = 0; i < str.length(); i += 6) {
        result += BrailleASCIITables.toASCII(str.substring(i, i + 6));
      }// for

      pen.println(result);
    } else if (args[0].equals("unicode")) {
      String result = "";

      for(int i = 0; i < str.length(); i++){
        String braille = BrailleASCIITables.toBraille(str.charAt(i));
        String unicode = BrailleASCIITables.toUnicode(braille);

        int hexval = Integer.parseInt(unicode);

        result += (char)hexval;
      }// for
      pen.println(result);
    }//else - if

  }// main
}// class BrailleASCII
